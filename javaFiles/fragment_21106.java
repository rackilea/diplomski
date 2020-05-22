GenericObjectPoolConfig config = new GenericObjectPoolConfig();
config.setMinIdle(2);
config.setMaxIdle(5);
config.setMaxTotal(20);

GenericObjectPool<Cipher> pool;
CipherFactory factory = new CipherFactory(); 
this.pool = new GenericObjectPool<Cipher>(factory, config);