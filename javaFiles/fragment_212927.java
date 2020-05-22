LoadingCache<String,Fizzbuzz> fizzbuzzes = Caffeine.newBuilder()
    .maximumSize(100)
    .expireAfterWrite(10, TimeUnit.DAYS)
    .build(key -> fetchFizzbuzzes(key));
fizzbuzzes.get("myKey"); // will automatically invoke fetchFizzbuzzes with 'myKey' as argument
fizzbuzzes.get("myKey"); // fetchFizzbuzzes won't be called as return value from previous call is added to the cache automatically


Cache<String, Fizzbuzz> fizzbuzzesManual = Caffeine.newBuilder()
     .maximumSize(100)
     .expireAfterWrite(10, TimeUnit.DAYS)
     .build();
fizzbuzzesManual.getIfPresent("myKey"); // will return null as no element for 'myKey' was added to the cache before