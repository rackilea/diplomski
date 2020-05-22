@SpringBootApplication
public class YourSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(YourSpringBootApplication.class, args);
  }

  @Configuration
  @EnableFilesystemStores
  public static class StoreConfig {
    File filesystemRoot() {
        return new File("/path/to/your/movies");
    }

    @Bean
    public FileSystemResourceLoader fsResourceLoader() throws Exception {
      return new FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
    }
  }

  @StoreRestResource(path="movie")
  public interface MovieStore extends Store<String> {
    //
  }
}