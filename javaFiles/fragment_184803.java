public static String encrypt(File publicKeyFile, String policy, String inputstr) throws IOException, AbeEncryptionException {
    AbePublicKey publicKey = AbePublicKey.readFromFile(publicKeyFile);
    try (InputStream in = new ByteArrayInputStream(inputstr.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream out = new ByteArrayOutputStream()) {
        encrypt(publicKey, policy, in, out);
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }
}