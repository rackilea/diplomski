KeyPair kp = KeyPairUtils.readKeyPair (new FileReader ("domain.key"));
// add error handling and close much like your getOrCreateKeyPair 
CertificateFactory cf = CertificateFactory.getInstance ("X.509");
Certificate cert0 = cf.generateCertificate (new FileInputStream ("domain.crt"));
Certificate cert1 = cf.generateCertificate (new FileInputStream ("chain.crt"));
// add similar error handling and close

KeyStore ks = KeyStore.getInstance ("jks"); // type doesn't really matter since it's in memory only
ks.load (null); 
ks.setKeyEntry ("anyalias", kp.getPrivate(), password, new Certificate[]{cert0,cert1});

// now create a KMF and KeyManager from this KeyStore,
// optionally a TMF and TrustManager, then SSLContext etc as in your existing code