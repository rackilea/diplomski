File cacheDir = StorageUtils.getOwnCacheDirectory(activity context, "your folder");//for caching

 // Get singletone instance of ImageLoader
 imageLoader = ImageLoader.getInstance();
 // Create configuration for ImageLoader (all options are optional)
 ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(a)
 // You can pass your own memory cache implementation
.discCache(new UnlimitedDiscCache(cacheDir)) // You can pass your own disc cache implementation
.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
.enableLogging()
.build();
// Initialize ImageLoader with created configuration. Do it once.
imageLoader.init(config);
options = new DisplayImageOptions.Builder()
.cacheInMemory(true)
.cacheOnDisk(true)
.showImageOnLoading(R.drawable.default_pic)//display stub image until image is loaded
.displayer(new RoundedBitmapDisplayer(20))
.build();