imageCache = CacheBuilder.newBuilder()
     .maximumWeight(maximumCacheSizeInBytes)
     .weigher(new Weigher<String, DeferredImage>() {
        public int weigh(String k, DeferredImage g) {
          return g.size();
        }
     })  
     .build(
        new CacheLoader<String, DeferredImage>() {
           public DeferredImage load(String pathname) throws IOException {
              return new DeferredImage(pathname);

           }
        });