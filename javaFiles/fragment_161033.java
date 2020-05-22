private static final String TEMPORARY_KEY_PASSWORD = "changeit";

private KeyStore getKeyStore() throws ConfigurationException {
    try {
        Certificate clientCertificate = loadCertificate(certificatePem);
        PrivateKey privateKey = loadPrivateKey(privateKeyPem);
        Certificate caCertificate = loadCertificate(caPem);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca-cert", caCertificate);
        keyStore.setCertificateEntry("client-cert", clientCertificate);
        keyStore.setKeyEntry("client-key", privateKey, TEMPORARY_KEY_PASSWORD.toCharArray(), new Certificate[]{clientCertificate});
        return keyStore;
    } catch (GeneralSecurityException | IOException e) {
        throw new ConfigurationException("Cannot build keystore", e);
    }
}

private Certificate loadCertificate(String certificatePem) throws IOException, GeneralSecurityException {
    CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
    final byte[] content = readPemContent(certificatePem);
    return certificateFactory.generateCertificate(new ByteArrayInputStream(content));
}

private PrivateKey loadPrivateKey(String privateKeyPem) throws IOException, GeneralSecurityException {
    return pemLoadPrivateKeyPkcs1OrPkcs8Encoded(privateKeyPem);
}

private byte[] readPemContent(String pem) throws IOException {
    final byte[] content;
    try (PemReader pemReader = new PemReader(new StringReader(pem))) {
        final PemObject pemObject = pemReader.readPemObject();
        content = pemObject.getContent();
    }
    return content;
}

private static PrivateKey pemLoadPrivateKeyPkcs1OrPkcs8Encoded(
        String privateKeyPem) throws GeneralSecurityException, IOException {
    // PKCS#8 format
    final String PEM_PRIVATE_START = "-----BEGIN PRIVATE KEY-----";
    final String PEM_PRIVATE_END = "-----END PRIVATE KEY-----";

    // PKCS#1 format
    final String PEM_RSA_PRIVATE_START = "-----BEGIN RSA PRIVATE KEY-----";
    final String PEM_RSA_PRIVATE_END = "-----END RSA PRIVATE KEY-----";

    if (privateKeyPem.contains(PEM_PRIVATE_START)) { // PKCS#8 format
        privateKeyPem = privateKeyPem.replace(PEM_PRIVATE_START, "").replace(PEM_PRIVATE_END, "");
        privateKeyPem = privateKeyPem.replaceAll("\\s", "");

        byte[] pkcs8EncodedKey = Base64.getDecoder().decode(privateKeyPem);

        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(new PKCS8EncodedKeySpec(pkcs8EncodedKey));

    } else if (privateKeyPem.contains(PEM_RSA_PRIVATE_START)) {  // PKCS#1 format

        privateKeyPem = privateKeyPem.replace(PEM_RSA_PRIVATE_START, "").replace(PEM_RSA_PRIVATE_END, "");
        privateKeyPem = privateKeyPem.replaceAll("\\s", "");

        DerInputStream derReader = new DerInputStream(Base64.getDecoder().decode(privateKeyPem));

        DerValue[] seq = derReader.getSequence(0);

        if (seq.length < 9) {
            throw new GeneralSecurityException("Could not parse a PKCS1 private key.");
        }

        // skip version seq[0];
        BigInteger modulus = seq[1].getBigInteger();
        BigInteger publicExp = seq[2].getBigInteger();
        BigInteger privateExp = seq[3].getBigInteger();
        BigInteger prime1 = seq[4].getBigInteger();
        BigInteger prime2 = seq[5].getBigInteger();
        BigInteger exp1 = seq[6].getBigInteger();
        BigInteger exp2 = seq[7].getBigInteger();
        BigInteger crtCoef = seq[8].getBigInteger();

        RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp, prime1, prime2,
                exp1, exp2, crtCoef);

        KeyFactory factory = KeyFactory.getInstance("RSA");

        return factory.generatePrivate(keySpec);
    }

    throw new GeneralSecurityException("Not supported format of a private key");
}