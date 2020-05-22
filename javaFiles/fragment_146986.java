@Configuration
@ConditionalOnProperty(name = "fileStore.class", havingValue="FileStoreA")
public class FileStoreAConfiguration {
    @Bean
    public IFileStore fileStore() {
        return new FileStoreA(...);
    }
}

@Configuration
@ConditionalOnProperty(name = "fileStore.class", havingValue="FileStoreB")
public class FileStoreBConfiguration {
    @Bean
    public IFileStore fileStore() {
        return new FileStoreB(...);
    }
}