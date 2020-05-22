ConcurrentMap<String, String> cache = 
    CacheBuilder.newBuilder()
        .maximumSize(2L)
        .<String, String>build().asMap();
cache.put("a", "b");
cache.put("b", "c");
System.out.println(cache);
cache.put("a", "d");
System.out.println(cache);
cache.put("c", "d");
System.out.println(cache);