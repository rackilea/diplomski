@AutoFactory(implementing = MyFactoryInterface.class)
public class ImageDownloader {
  // ... otherwise as above...
}

@Module(...)
class MyModule {
  @Provides MyFactoryInterface factoryImpl(ImageDownloaderFactory impl) {
    return impl;
  }
}