@Override
public void setExpire(
                String key,
                int expireTime) {
    Jedis jedis = pool.getResource();
    try {
        jedis.expire(key, expireTime);
    } finally {
        jedis.close();
    }
}