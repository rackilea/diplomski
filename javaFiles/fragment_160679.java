KeyStore keystore;

        java.security.Security.addProvider(
                new org.bouncycastle.jce.provider.BouncyCastleProvider()
        );

        PEMParser pemParser = new PEMParser(new StringReader(privateKey));
        Object object = pemParser.readObject();
        PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(pwd.toCharArray());
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        KeyPair kp;
        if (object instanceof PEMEncryptedKeyPair) {
            kp = converter.getKeyPair(((PEMEncryptedKeyPair) object).decryptKeyPair(decProv));
        } else {
            kp = converter.getKeyPair((PEMKeyPair) object);
        }
        RSAPrivateKey result = (RSAPrivateKey)kp.getPrivate();

        keystore= KeyStore.getInstance("pkcs12");
        keystore.load(null, pwd.toCharArray());
        keystore.setKeyEntry(keyStoreAlias, result, pwd.toCharArray(), new Certificate[]{certificate});