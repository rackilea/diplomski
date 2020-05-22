URI redisURI = new URI(System.getenv("REDISTOGO_URL"));
JedisPool pool = new JedisPool(new JedisPoolConfig(),
    redisURI.getHost(), 
    redisURI.getPort(),
    Protocol.DEFAULT_TIMEOUT, 
    redisURI.getUserInfo().split(":",2)[1]);