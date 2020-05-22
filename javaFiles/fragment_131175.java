String cert = "...";
byte[] encodedCert = cert.getBytes("UTF-8");
byte[] decodedCert = Base64.decodeBase64(encodedCert);
CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
InputStream in = new ByteArrayInputStream(decodedCert);
X509Certificate certificate = (X509Certificate)certFactory.generateCertificate(in);
PublicKey publicKey = ((RSAPublicKey)certificate.getPublicKey());