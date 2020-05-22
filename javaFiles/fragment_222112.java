public byte[] generateSalt(int length) {
    SecureRandom random = new SecureRandom();
    byte bytes[] = new byte[length];
    random.nextBytes(bytes);
    return bytes;
}