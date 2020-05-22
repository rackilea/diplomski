Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
Cipher cipher = Cipher.getInstance(TRANSFORMATION);
cipher.init(cipherMode, secretKey);

try (CipherOutputStream out = new CipherOutputStream(
    new BufferedOutputStream(
        new FileOutputStream(outputFile)), cipher)) {

    Files.copy(inputFile.toPath(), out);
}