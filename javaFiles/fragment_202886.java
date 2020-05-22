byte[] certAndKey = fileToBytes(new File(pemPath));
    byte[] certBytes = parseDERFromPEM(certAndKey, "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----");
    byte[] keyBytes = parseDERFromPEM(certAndKey, "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");

    X509Certificate cert = generateCertificateFromDER(certBytes);              
    RSAPrivateKey key  = generatePrivateKeyFromDER(keyBytes);