final Set<ClusterNode> nodes = new HashSet<>(ignite.cluster().forDataNodes("myCache") 
                .forHost(ignite.cluster().localNode()).nodes()); 

qry.setRemoteFilterFactory(new Factory<CacheEntryEventFilter<String, Long>() { 
        @Override 
        public CacheEntryEventFilter<String, Long> create() { 
           return new CacheEntryEventFilter<String, Long>() { 
               @Override 
               public boolean evaluate( 
                    CacheEntryEvent<? extends String, ? extends Long> event) throws CacheEntryListenerException { 
                    return nodes.contains(ignite.cluster().localNode()); 
               } 
            }; 
        } 
    });