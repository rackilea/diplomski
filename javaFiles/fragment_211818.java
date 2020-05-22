public class CustomSslContextSocketFactory extends JSSESocketFactory {

    public static final AtomicReference<CustomSslContext> customSslContext =
        new AtomicReference<CustomSslContext>();

    public CustomSslContextSocketFactory(AbstractEndpoint endpoint) {
        super(endpoint);
    }

    @Override
    public KeyManager[] getKeyManagers() throws Exception {
        return (customSslContext.get() == null ? super.getKeyManagers() : customSslContext.get().getKeyManagers(this));
    }
}