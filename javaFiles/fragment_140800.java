public static java.security.cert.X509Certificate getCertificate(String pemfile) throws Exception
{
    java.security.cert.X509Certificate cert = null;
    try {
        FileReader fRd = new FileReader(pemfile);
        final PemReader certReader = new PemReader(fRd);
        final PemObject certAsPemObject = certReader.readPemObject();
        if (!certAsPemObject.getType().equalsIgnoreCase("CERTIFICATE")) {
            throw new Exception("Certificate file does not contain a certificate but a " + certAsPemObject.getType());
        }
        final byte[] x509Data = certAsPemObject.getContent();
        final CertificateFactory fact = CertificateFactory.getInstance("X509");
        cert = (X509Certificate) fact.generateCertificate(new ByteArrayInputStream(x509Data));
        if (!(cert instanceof X509Certificate)) {
            throw new Exception("Certificate file does not contain an X509 certificate");
        }

    } catch (FileNotFoundException e) {
        throw new IOException("Can't find file " + pemfile);
    }
    return cert;
}