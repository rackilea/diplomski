static public byte[] sign(byte[] data, PrivateKey privateKey, int saltLength) throws Exception {
    SHA256withRSACustomPadding instance = new SHA256withRSACustomPadding(padding);
    instance.initSign(privateKey);
    instance.update(data);
    return instance.sign();
}