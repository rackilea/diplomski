@Override
    public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }