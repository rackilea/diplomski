Path file = Files.createTempFile(null, ".txt");
try (InputStream stream = this.getClass().getResourceAsStream("/key.txt")) {
    Files.copy(stream, file, StandardCopyOption.REPLACE_EXISTING);
}

aesEncrypt.setSecretKey(file.toString());