File cacheDir = StorageUtils.getOwnCacheDirectory(a, "UniversalImageLoader/Cache");
  imageLoader = ImageLoader.getInstance();

   ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(a)
          // You can pass your own memory cache implementation
         .discCache(new UnlimitedDiscCache(cacheDir)) // You can pass your own disc cache implementation
         .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
         .enableLogging()
         .build();
 // Initialize ImageLoader with created configuration. Do it once.
 imageLoader.init(config);
 options = new DisplayImageOptions.Builder()
.showStubImage(R.drawable.stub_id)//dummy image
.cacheInMemory()
.cacheOnDisc()
.displayer(new RoundedBitmapDisplayer(20))
.build();