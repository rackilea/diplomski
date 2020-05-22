public KeyPair ecKeyPairGenerator(String curveName) throws Exception {
    KeyPair keyPair;
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
            "ECDSA", "BC");
    ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec(
            curveName);
    keyPairGenerator.initialize(ecGenParameterSpec, new SecureRandom());
    keyPair = keyPairGenerator.generateKeyPair();
    java.security.PublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
    System.out.println("JAVA EC PublicKey: "
            + Helper.toHex(ecPublicKey.getEncoded()));

    // write private key into a file. Just for testing purpose
    FileOutputStream fileOutputStream = new FileOutputStream(
            "ECPrivateKey.key");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            fileOutputStream);
    objectOutputStream.writeObject(keyPair.getPrivate());
    objectOutputStream.close();
    return keyPair;
}