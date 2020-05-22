public void release() {
    pool.destroy();
}
public static class JedisWrapper implements AutoCloseable {   
    private final JedisPoolConfig pool;
    private final Jedis jedis;
    public JedisWrapper(JedisPoolConfig pool, Jedis jedis) {
        this.pool = pool;
        this.jedis = jedis;
    }
    public Jedis get() {
        return jedis;
    }
    @Override
    public void close() {
        pool.returnResourceObject(jedis);
    }
}
public JedisWrapper getJedis() {
    return new JedisWrapper(pool, pool.getResource());
}
// you can delete this method
public void returnJedis(Jedis jedis) {
    pool.returnResourceObject(jedis);
}