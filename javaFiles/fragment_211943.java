public class MySSLSocketFactory extends SocketFactory {
    private static final AtomicReference<MySSLSocketFactory> defaultFactory = new AtomicReference<>();

    private SSLSocketFactory sf;

    public MySSLSocketFactory() {
        KeyStore keyStore = ... /* Get a keystore containing the self-signed certificate) */
        TrustManagerFactory tmf = TrustManagerFactory.getInstance();
        tmf.init(keyStore);
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, tmf.getTrustManagers(), null);
        sf = ctx.getSocketFactory();
    }

    public static SocketFactory getDefault() {
        final MySSLSocketFactory value = defaultFactory.get();
        if (value == null) {
            defaultFactory.compareAndSet(null, new MySSLSocketFactory());
            return defaultFactory.get();
        }
        return value;
    }

    @Override
    public Socket createSocket(final String s, final int i) throws IOException {
        return sf.createSocket(s, i);
    }

    @Override
    public Socket createSocket(final String s, final int i, final InetAddress inetAddress, final int i1) throws IOException {
        return sf.createSocket(s, i, inetAddress, i1);
    }

    @Override
    public Socket createSocket(final InetAddress inetAddress, final int i) throws IOException {
        return sf.createSocket(inetAddress, i);
    }

    @Override
    public Socket createSocket(final InetAddress inetAddress, final int i, final InetAddress inetAddress1, final int i1) throws IOException {
        return sf.createSocket(inetAddress, i, inetAddress1, i1);
    }
}