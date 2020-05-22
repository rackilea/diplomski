private static byte[] toByteArray(File file) throws IOException {
    byte[] allBytes = Files.readAllBytes(file.toPath());
    for (int i = 0; i < allBytes.length; i++) {
        if (allBytes[i] == '\\') {
            allBytes[i++] = 10;
            allBytes[i++] = 10;
        }
    }
    return allBytes;
}