static {
    try {
        SSLContext ssl = SSLContext.getDefault();
        ssl.init(null, new X509TrustManager[] {new AnyTrustManager()}, null);
    } catch (NoSuchAlgorithmException ex) {
        throw new Error(ex);
    } catch (KeyManagementException ex) {
        throw new Error(ex);
    }
}