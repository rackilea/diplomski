private final ConcurrentMap<Long, Foo> fooCache = new MapMaker()
    .softValues()
    .makeComputingMap(new Function<Long, Foo>() {
          public Foo apply(Long id) {
            return getFooFromServer(id);
          }
        });

 public Foo getFoo(Long id) {
   return fooCache.get(id);
 }