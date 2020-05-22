ConcurrentMap<Key, CyclingArray> graphs = new MapMaker()
       .concurrencyLevel(32)
       .makeComputingMap(
           new Function<Key, CyclingArray>() {
                public CyclingArray  apply(Key key) {
                    return new CyclingArray();  // only called if the key wasn't already    
                }              
           });