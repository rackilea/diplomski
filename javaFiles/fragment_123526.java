private List<X509TrustManager> trustManagers = new ArrayList<X509TrustManager>();

public MyCustomTrustManager() {
    TrustManagerFactory tmFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmFactory.init((KeyStore)null);

    for (TrustManager tm : tmFactory.getTrustManagers()) {
        if (tm instanceof X509TrustManager)
            trustManagers.add((X509TrustManager)tm);
    }
}