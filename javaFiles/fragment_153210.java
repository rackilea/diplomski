public static String get(String key, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = null;
        String result = null;
        try {
            jredis = poolItem.getResource();
            result = jredis.get(key);
        } catch (Exception e) {
            log.error("get value error", e);
        } finally {
            if (jredis != null) {
                jredis.close();
            }
        }
        return result;
    }