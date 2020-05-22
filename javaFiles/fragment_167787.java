KeyStore root = KeyStore.getInstance("Windows-ROOT");
root.load(null);
/* certificate must be DER-encoded */
FileInputStream in = new FileInputStream("C:/path/to/root/cert/root.der");
X509Certificate cacert = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(in);
root.setCertificateEntry("CACert Root CA", cacert);