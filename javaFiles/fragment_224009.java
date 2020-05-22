public class MyProperties extends java.util.Properties {
private static final long serialVersionUID = -207802321379271320L;

public MyProperties() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("jasypt");
    super.defaults = new EncryptableProperties(encryptor);
}

@Override
public synchronized Object put(Object paramK, Object paramV) {
    return super.defaults.put(paramK, paramV);
}
}