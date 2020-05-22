public static Optional<String> getFileMd5(String filePath) {
    try {
        // your original code
    }
    catch (IOException e) {
        throw new UncheckedIOException(e);
    }
    catch (NoSuchAlgorithmException e) {
        throw MyCustomCryptoException(e);
    }
}