public class TestFtpSync {

    static final Logger log = LoggerFactory.getLogger(TestFtpSync.class);
    static final String FTP_ROOT_DIR = "target" + File.separator + "ftproot";
    // org.apache.ftpserver:ftpserver-core:1.0.6
    static FtpServer server;

    @BeforeClass
    public static void startServer() throws FtpException {

        File ftpRoot = new File (FTP_ROOT_DIR);
        ftpRoot.mkdirs();
        TestUserManager userManager = new TestUserManager(ftpRoot.getAbsolutePath());
        FtpServerFactory serverFactory = new FtpServerFactory();
        serverFactory.setUserManager(userManager);
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(4444);
        serverFactory.addListener("default", factory.createListener());
        server = serverFactory.createServer();
        server.start();
    }

    @AfterClass
    public static void stopServer() {

        if (server != null) {
            server.stop();
        }
    }

    File ftpFile = Paths.get(FTP_ROOT_DIR, "test1.txt").toFile();
    File ftpFile2 = Paths.get(FTP_ROOT_DIR, "test2.txt").toFile();

    @Test
    public void syncDir() {

        // org.springframework.integration:spring-integration-ftp:4.3.5.RELEASE
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(FtpSyncConf.class);
            ctx.refresh();
            PollableChannel msgChannel = ctx.getBean("inputChannel", PollableChannel.class);
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 2; i++) {
                    storeFtpFile();
                }
                for (int i = 0; i < 4; i++) {
                    fetchMessage(msgChannel);
                }
            }
        } catch (Exception e) {
            throw new AssertionError("FTP test failed.", e);
        } finally {
            ctx.close();
            cleanup();
        }
    }

    boolean tswitch = true;

    void storeFtpFile() throws IOException, InterruptedException {

        File f = (tswitch ? ftpFile : ftpFile2);
        tswitch = !tswitch;
        log.info("Writing message " + f.getName());
        Files.write(f.toPath(), ("Hello " + System.currentTimeMillis()).getBytes());
    }

    Message<?> fetchMessage(PollableChannel msgChannel) {

        log.info("Fetching message.");
        Message<?> msg = msgChannel.receive(1000L);
        if (msg == null) {
            log.info("No message.");
        } else {
            log.info("Have a message: " + msg);
        }
        return msg;
    }

    void cleanup() {

        delFile(ftpFile);
        delFile(ftpFile2);
        File d = new File(FtpSyncConf.LOCAL_DIR);
        if (d.isDirectory()) {
            for (File f : d.listFiles()) {
                delFile(f);
            }
        }
        log.info("Finished cleanup");
    }

    void delFile(File f) {

        if (f.isFile()) {
            if (f.delete()) {
                log.info("Deleted " + f);
            } else {
                log.error("Cannot delete file " + f);
            }
        }
    }

}

public class MlistFtpSessionFactory extends AbstractFtpSessionFactory<MlistFtpClient> {

    @Override
    protected MlistFtpClient createClientInstance() {
        return new MlistFtpClient();
    }

}

public class MlistFtpClient extends FTPClient {

    @Override
    public FTPFile[] listFiles(String pathname) throws IOException {
        return super.mlistDir(pathname);
    }
}

@EnableIntegration
@Configuration
public class FtpSyncConf {

    private static final Logger log = LoggerFactory.getLogger(FtpSyncConf.class);

    public static final String LOCAL_DIR = "/tmp/received";

    @Bean(name = "ftpMetaData")
    public ConcurrentMetadataStore ftpMetaData() {
        return new SimpleMetadataStore();
    }

    @Bean(name = "localMetaData")
    public ConcurrentMetadataStore localMetaData() {
        return new SimpleMetadataStore();
    }

    @Bean(name = "ftpFileSyncer")
    public FtpUpdatingFileSynchronizer ftpFileSyncer(
            @Qualifier("ftpMetaData") ConcurrentMetadataStore metadataStore) {

        MlistFtpSessionFactory ftpSessionFactory = new MlistFtpSessionFactory();
        ftpSessionFactory.setHost("localhost");
        ftpSessionFactory.setPort(4444);
        ftpSessionFactory.setUsername("demo");
        ftpSessionFactory.setPassword("demo");

        FtpPersistentAcceptOnceFileListFilter fileFilter = new FtpPersistentAcceptOnceFileListFilter(metadataStore, "ftp");
        fileFilter.setFlushOnUpdate(true);
        FtpUpdatingFileSynchronizer ftpFileSync = new FtpUpdatingFileSynchronizer(ftpSessionFactory);
        ftpFileSync.setFilter(fileFilter);
        // ftpFileSync.setDeleteRemoteFiles(true);
        return ftpFileSync;
    }

    @Bean(name = "syncFtp")
    @InboundChannelAdapter(value = "inputChannel", poller = @Poller(fixedDelay = "500", maxMessagesPerPoll = "1"))
    public MessageSource<File> syncChannel(
            @Qualifier("localMetaData") ConcurrentMetadataStore metadataStore,
            @Qualifier("ftpFileSyncer") FtpUpdatingFileSynchronizer ftpFileSync) throws Exception {

        FtpInboundFileSynchronizingMessageSource messageSource = new FtpInboundFileSynchronizingMessageSource(ftpFileSync);
        File receiveDir = new File(LOCAL_DIR);
        receiveDir.mkdirs();
        messageSource.setLocalDirectory(receiveDir);
        messageSource.setLocalFilter(new FileSystemPersistentAcceptOnceFileListFilter(metadataStore, "local"));
        log.info("Message source bean created.");
        return messageSource;
    }

    @Bean(name = "inputChannel")
    public PollableChannel inputChannel() {

        QueueChannel channel = new QueueChannel();
        log.info("Message channel bean created.");
        return channel;
    }

}

/**
 * Copied from https://github.com/spring-projects/spring-integration-samples/tree/master/basic/ftp/src/test/java/org/springframework/integration/samples/ftp/support
 * @author Gunnar Hillert
 *
 */
public class TestUserManager extends AbstractUserManager {
    private BaseUser testUser;
    private BaseUser anonUser;

    private static final String TEST_USERNAME = "demo";
    private static final String TEST_PASSWORD = "demo";

    public TestUserManager(String homeDirectory) {
        super("admin", new ClearTextPasswordEncryptor());

        testUser = new BaseUser();
        testUser.setAuthorities(Arrays.asList(new Authority[] {new ConcurrentLoginPermission(1, 1), new WritePermission()}));
        testUser.setEnabled(true);
        testUser.setHomeDirectory(homeDirectory);
        testUser.setMaxIdleTime(10000);
        testUser.setName(TEST_USERNAME);
        testUser.setPassword(TEST_PASSWORD);

        anonUser = new BaseUser(testUser);
        anonUser.setName("anonymous");
    }

    public User getUserByName(String username) throws FtpException {
        if(TEST_USERNAME.equals(username)) {
            return testUser;
        } else if(anonUser.getName().equals(username)) {
            return anonUser;
        }

        return null;
    }

    public String[] getAllUserNames() throws FtpException {
        return new String[] {TEST_USERNAME, anonUser.getName()};
    }

    public void delete(String username) throws FtpException {
        throw new UnsupportedOperationException("Deleting of FTP Users is not supported.");
    }

    public void save(User user) throws FtpException {
        throw new UnsupportedOperationException("Saving of FTP Users is not supported.");
    }

    public boolean doesExist(String username) throws FtpException {
        return (TEST_USERNAME.equals(username) || anonUser.getName().equals(username)) ? true : false;
    }

    public User authenticate(Authentication authentication) throws AuthenticationFailedException {
        if(UsernamePasswordAuthentication.class.isAssignableFrom(authentication.getClass())) {
            UsernamePasswordAuthentication upAuth = (UsernamePasswordAuthentication) authentication;

            if(TEST_USERNAME.equals(upAuth.getUsername()) && TEST_PASSWORD.equals(upAuth.getPassword())) {
                return testUser;
            }

            if(anonUser.getName().equals(upAuth.getUsername())) {
                return anonUser;
            }
        } else if(AnonymousAuthentication.class.isAssignableFrom(authentication.getClass())) {
            return anonUser;
        }

        return null;
    }
}