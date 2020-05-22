public class redisdb {
    JedisPool pool;

    public redisdb() {
        pool = new JedisPool(new JedisPoolConfig(), "192.168.56.101", 6179)
    }

    public void query() {
        Jedis jedis = pool.getResource();
        try {
            jedis.append("foo", "bar"); 
        } catch (JedisConnectionException e) {
            // returnBrokenResource when the state of the object is unrecoverable
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
          /// ... it's important to return the Jedis instance to the pool once you've finished using it
          if (null != jedis)
            pool.returnResource(jedis);
        }
    }
}