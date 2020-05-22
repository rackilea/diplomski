char [] passch = password.toCharArray();

    com.ibm.crypto.provider.JavaKeyStore keystore = new JavaKeyStore();

    keystore.engineLoad(new FileInputStream(new File(pathKeyFileJKS)), null);
    KeyStore.TrustedCertificateEntry privKeyEntry =  (TrustedCertificateEntry) 
    keystore.engineGetEntry("eecc-KeyStore", new KeyStore.PasswordProtection(passch)); 

    X509CertImpl cert = (X509CertImpl) privKeyEntry.getTrustedCertificate();

    cert.checkValidity();

    PublicKey publicKey  = cert.getPublicKey();