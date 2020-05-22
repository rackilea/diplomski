@Override
public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
    throw new UnsupportedOperationException();
}

@Override
public X509Certificate[] getAcceptedIssuers() {
    throw new UnsupportedOperationException();
}