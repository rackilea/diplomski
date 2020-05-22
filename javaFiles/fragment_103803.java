JedisPool pool = new JedisPool(...);
try {
    Jedis jedis = pool.getResource();
    // Is connected
} catch (JedisConnectionException e) {
    // Not connected
}