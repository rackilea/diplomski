@Generated("com.google.auto.factory.processor.AutoFactoryProcessor")
public final class ImageDownloaderFactory {
  private final Provider<ExampleClasses.HttpClient> httpClientProvider;
  private final Provider<java.util.concurrent.ExecutorService> executorServiceProvider;

  @Inject
  public ImageDownloaderFactory(
      Provider<ExampleClasses.HttpClient> httpClientProvider,
      Provider<java.util.concurrent.ExecutorService> executorServiceProvider) {
    this.httpClientProvider = httpClientProvider;
    this.executorServiceProvider = executorServiceProvider;
  }

  public ImageDownloader create(ImageCallback callback, URL imageUrl) {
    return new ImageDownloader(
        httpClientProvider.get(), 
        executorServiceProvider.get(), 
        callback, 
        imageUrl);
  }
}