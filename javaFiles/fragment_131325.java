JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
jedisConnectionFactory.setHostName("<cluster-name>.mdbnso.0001.use1.cache.amazonaws.com");
jedisConnectionFactory.setPort(6379);
jedisConnectionFactory.afterPropertiesSet();

RedisTemplate redisTemplate = new RedisTemplate();
redisTemplate.setConnectionFactory(jedisConnectionFactory);
redisTemplate.afterPropertiesSet();

IdempotentRepository redisIdempotentRepository = new RedisIdempotentRepository(redisTemplate, "redis");

from(source)
    .idempotentConsumer(simple("${in.header.CamelFileName}"), redisIdempotentRepository)
    .log("Uploading file ${file:name} started...")
    .to(destination)
    .log("Uploading file ${file:name} completed...");