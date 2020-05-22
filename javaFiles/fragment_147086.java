Jedis jedis;
try {
    jedis = RedisManager.getInstance().getJedis();
    ...
} finally {
    if (jedis != null) {
       RedisManager.getInstance().returnJedis(jedis);
       jedis = null;
    }
}