LoadingCache<String, List<Location>> locations = CacheBuilder.newBuilder()
     .maximumSize(100000)
     .build(
             new CacheLoader<String, List<Location>>() {
                 @Override
                 public List<Location> load(String key)  {
                     return Collections.unmodifiableList(
                         _getLocationListByTranscriptId(key));
                 }
             });