static class TrustManagerDelegate implements X509TrustManager {

    private final X509TrustManager trustManager;

    TrustManagerDelegate(final X509TrustManager trustManager) {
        super();
        this.trustManager = trustManager;
    }

    @Override
    public void checkClientTrusted(
            final X509Certificate[] chain, final String authType) throws CertificateException {
        trustManager.checkClientTrusted(chain, authType);
    }

    @Override
    public void checkServerTrusted(
            final X509Certificate[] chain, final String authType) {
        try {
            trustManager.checkServerTrusted(chain, authType);
        } catch (CertificateException ex) {
            // Implement proper logging;
            System.out.println(chain[0]);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return trustManager.getAcceptedIssuers();
    }

}