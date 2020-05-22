Date validityBeginDate = new Date(System.currentTimeMillis());
Date validityEndDate = new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000); //1 year from now

KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
keyPairGenerator.initialize(4096, new SecureRandom());

KeyPair keyPair = keyPairGenerator.generateKeyPair();

X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();
X500Principal dnName = new X500Principal("CN=John Doe");

certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
certGen.setSubjectDN(dnName);
certGen.setIssuerDN(dnName);
certGen.setNotBefore(validityBeginDate);
certGen.setNotAfter(validityEndDate);
certGen.setPublicKey(keyPair.getPublic());
certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

X509Certificate cert = certGen.generate(keyPair.getPrivate(), "BC");