new Thread(new Runnable() {
        @Override
        public void run() {
            Jedis subscriberJedis = new Jedis("localhost");
            try {
                subscriberJedis.subscribe(new JedisPubSub() …..,"CC");
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }).start();