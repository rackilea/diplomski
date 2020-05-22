String encryptString(String text, Character fileType) {
    return encryptBytes(text.getBytes(StandardCharsets.UTF_8), fileType);
}
String decryptString(String cipherText, Character fileType) {
    return new String(decryptBytes(cipherText, fileType), StandardCharsets.UTF_8);
}