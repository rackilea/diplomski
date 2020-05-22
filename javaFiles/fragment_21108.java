public class CipherFactoryImpl extends BasePooledObjectFactory<PooledCipher> 
    implements CipherFactory {

    private final GenericObjectPoolConfig config;
    private final GenericObjectPool<PooledCipher> pool;
    private final String transformation;
    private final int opmode;
    private final Key key;
    private final AlgorithmParameters params;
    private final String secretKeySpecAlgorithm;

    public CipherFactoryImpl(GenericObjectPoolConfig config, String transformation, int opmode, Key key, AlgorithmParameters params, String secretKeySpecAlgorithm) {
        this.config = config;
        this.pool = new GenericObjectPool<PooledCipher>(this, config);
        this.transformation = transformation;
        this.opmode = opmode;
        this.key = key;
        this.params = params;       
        this.secretKeySpecAlgorithm = secretKeySpecAlgorithm
    }

    @Override
    public PooledCipher create() throws Exception {
        return new PooledCipherImpl(pool, transformation, opmode, key, params, secretKeySpecAlgorithm);
    }

    @Override
    public PooledCipher getCipher() throws Exception {
        return pool.borrowObject();
    }

    @Override
    public void destroyObject(PooledObject<PooledCipher> p) throws Exception {
        try {
            PooledCipherImpl cipherImpl = (PooledCipherImpl)p.getObject();
            // do whatever you need with cipherImpl to destroy it
        } finally {
            super.destroyObject(p);
        }
    }

    @Override
    public void close() {
        pool.close();
    }

    @Override
    public PooledObject<PooledCipher> wrap(PooledCipher cipher) {
        return new DefaultPooledObject<PooledCipher>(cipher);
    }
}