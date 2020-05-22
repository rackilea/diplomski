@Configuration
public class WatchServiceConfig {

    @Value("${dirPath}")
    private String dirPath;

    @Conditional(FolderCondition.class)
    @Bean
    public WatchService watchService() throws IOException {
        WatchService watchService = null;
        watchService = FileSystems.getDefault().newWatchService();
        Paths.get(dirPath).register(watchService, ENTRY_CREATE);
        System.out.println("Started watching directory");
        return watchService;
    }