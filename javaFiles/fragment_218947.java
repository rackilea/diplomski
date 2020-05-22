private static byte[] createHeadForNamedCurve(String name, int size)
        throws NoSuchAlgorithmException,
        InvalidAlgorithmParameterException, IOException {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
    ECGenParameterSpec m = new ECGenParameterSpec(name);
    kpg.initialize(m);
    KeyPair kp = kpg.generateKeyPair();
    byte[] encoded = kp.getPublic().getEncoded();
    return Arrays.copyOf(encoded, encoded.length - 2 * (size / Byte.SIZE));
}