@AutoFactory
public class ImageDownloader {
  // Get these dependencies from the injector.
  private final HttpClient httpClient;
  private final ExecutorService executorService;

  // Get these from the caller.
  private final URL imageUrl;
  private final ImageCallback callback;

  ImageDownloader(
      @Provided HttpClient httpClient,
      @Provided ExecutorService executorService,
      ImageCallback callback,
      URL imageUrl) {
    // assignments
  }
}