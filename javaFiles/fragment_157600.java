public class ExampleFactoryBean implements FactoryBean<TrustManagerFactory> {

    private Resource keystore;
    private String password;

    @Override
    public TrustManagerFactory getObject() throws Exception {
            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(keystore.getInputStream(), password.toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(truststore);
            return tmf;
    }

    @Override
    public Class<?> getObjectType() {
        return TrustManagerFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setKeystore(Resource keystore) {
        this.keystore = keystore;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}