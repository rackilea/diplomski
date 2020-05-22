private X509Certificate buildDummyCertificate() throws CertificateException {
    CertificateFactory cFactory = CertificateFactory.getInstance("X.509");
    ByteArrayInputStream is = new ByteArrayInputStream(PEM_CERTIFICATE.getBytes(StandardCharsets.US_ASCII));
    return (X509Certificate) cFactory.generateCertificate(is);
}

private static final String PEM_CERTIFICATE = "-----BEGIN CERTIFICATE-----\n"
                                                  + "MIIEMDCCAxigAwIBAgI..."
                                                  ....
                                                  + "...n1xJLO3k=-----END CERTIFICATE-----";