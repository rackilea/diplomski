ExecutorService es = Executors.newCachedThreadPool();

es.submit(new RunJedis(jedis1));
es.submit(new RunJedis(jedis2));
es.submit(new RunJedis(jedis3));
es.submit(new RunJedis(jedis4));
es.submit(new RunJedis(jedis5));
es.submit(new RunJedis(jedis6));
es.submit(new RunJedis(jedis7));
es.submit(new RunJedis(jedis8));

class RunJedis{
    Jedis jedis;
    RunJedis(Jedis jedis1){
        this.jedis=jedis1;
    }

    void run(){ 
        System.out.println(jedis.eval(SCRIPT, 0).toString());
    }
}