String encryptObject(Serializable obj, Character fileType) {
    // serialize here
    return encryptBytes(bytes, fileType);
}
Serializable decryptObject(String cipherText, Character fileType) {
    byte[] bytes = decryptBytes(cipherText, fileType);
    // deserialize here
}