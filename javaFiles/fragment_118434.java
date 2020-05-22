public KeyPair createKeyPair(byte[] encodedPrivateKey, byte[] encodedPublicKey) {
    try {
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
        KeyFactory generator = KeyFactory.getInstance(ASYM_ALGORITHM);
        PrivateKey privateKey = generator.generatePrivate(privateKeySpec);

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
        PublicKey publicKey = generator.generatePublic(publicKeySpec);
        return new KeyPair(publicKey, privateKey);
    } catch (Exception e) {
        throw new IllegalArgumentException("Failed to create KeyPair from provided encoded keys", e);
    }
}