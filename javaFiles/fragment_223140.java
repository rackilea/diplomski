@Configuration
@EnableIntegration
public class SftpConfiguration {

    @Value("${config.adapter.ftp.host}")
    private String host;

    @Value("${config.adapter.ftp.port}")
    private int port;

    @Value("${config.adapter.ftp.user}")
    private String user;

    @Value("${config.adapter.ftp.password}")
    private String password;

    @Autowired
    private FtpOrderRequestHandler handler;

    @Autowired
    ConfigurableApplicationContext context;

    @Value("${config.adapter.ftp.excel.sourceFolder}")
    private String sourceDir;

    @Value("${config.adapter.ftp.excel.localFolder}")
    private String localDir;

    @Value("${config.adapter.ftp.excel.backupFolder}")
    private String backupDir;

    @Value("${config.adapter.ftp.statusExcel.destinationFolder}")
    private String statusDest;

    private static final Logger LOGGER = LoggerFactory.getLogger(SftpConfiguration.class);


    @Bean
    public SessionFactory<LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost(host);
        factory.setPort(port);
        factory.setUser(user);
        factory.setPassword(password);
        factory.setAllowUnknownKeys(true);
        return new CachingSessionFactory<LsEntry>(factory);
    }

    @Bean
    public SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {
        SftpInboundFileSynchronizer fileSynchronizer = new SftpInboundFileSynchronizer(sftpSessionFactory());
        fileSynchronizer.setDeleteRemoteFiles(true);
        fileSynchronizer.setRemoteDirectory(sourceDir);
        fileSynchronizer.setFilter(new SftpSimplePatternFileListFilter("*.xlsx"));
        return fileSynchronizer;
    }

    @Bean
    @InboundChannelAdapter(channel = "sftpChannel", poller = @Poller(cron = "${config.cron.cataligent.order}"), autoStartup = "true")
    public MessageSource<File> sftpMessageSource() {
        SftpInboundFileSynchronizingMessageSource source = new SftpInboundFileSynchronizingMessageSource(
                sftpInboundFileSynchronizer());
        source.setLocalDirectory(new File(localDir));
        source.setAutoCreateLocalDirectory(true);
        source.setLocalFilter(new AcceptOnceFileListFilter<File>());
        return source;
    }


    @Bean
    @ServiceActivator(inputChannel = "sftpChannel")
    public MessageHandler handlerOrder() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                try {
                    SFTPGateway gateway = context.getBean(SFTPGateway.class);
                    final File orderFile = (File) message.getPayload();
                    gateway.sendToSftp(orderFile);
                    LOGGER.debug("{} is picked by scheduler and moved to {} folder",orderFile.getName(),backupDir);
                    handler.handle((File) message.getPayload());
                    handler.deleteFileFromLocal((File) message.getPayload());
                    LOGGER.info("Processing of file {} is completed",orderFile.getName());
                } catch (IOException e) {
                    LOGGER.error("Error occurred while processing order file exception is {}",e.getMessage());
                }
            }

        };
    }

    @Bean
    @ServiceActivator(inputChannel = "sftpChannelDest")
    public MessageHandler handlerOrderBackUp() {
        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
        handler.setRemoteDirectoryExpression(new LiteralExpression(backupDir));
        return handler;
    }

    @Bean
    @ServiceActivator(inputChannel = "sftpChannelStatus")
    public MessageHandler handlerOrderStatusUS() {
        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
        handler.setRemoteDirectoryExpression(new LiteralExpression(statusDest));
        return handler;
    }



    @MessagingGateway
    public interface SFTPGateway {
        @Gateway(requestChannel = "sftpChannelDest")
        void sendToSftp(File file);

        @Gateway(requestChannel = "sftpChannelStatus")
        void sendToSftpOrderStatus(File file);

    }

}