KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        BigInteger d = rsaPrivateKey.getPrivateExponent();

        // Flip some bits in d

        BigInteger newD = d.flipBit(29);

        // Make a new RSA private key with the modified private exponent

        RSAPrivateKeySpec newRSAPrivateSpec = new RSAPrivateKeySpec(rsaPrivateKey.getModulus(), newD);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateKey newPrivateKey = (RSAPrivateKey) kf.generatePrivate(newRSAPrivateSpec);