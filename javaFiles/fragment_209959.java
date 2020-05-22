// This should be a global singleton
    JedisPool jedisPool = new JedisPool(poolConfig,"localhost", 6379, 100);

    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
    newFixedThreadPool.submit(new Runnable() {

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Jedis jedis = jedisPool.getResource();
                try {
                   jedis.publish("CC", new Date().toString());
                } catch (Exception e) {
                   e.printStackTrace();
                } finally {
                   jedisPool.returnResource(jedis);
                }
            }

        }
    });