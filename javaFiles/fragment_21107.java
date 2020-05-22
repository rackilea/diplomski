public interface PooledCipher extends java.io.Closeable {
    byte[] doFinal(byte[] bytes) throws Exception;
    SecretKeySpec getSecretKeySpec(byte[] bytes) throws Exception;
}

public interface CipherFactory {
    PooledCipher getCipher() throws Exception;        
    void close();
}