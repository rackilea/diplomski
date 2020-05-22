try {
    // Generate a temporary key. In practice, you would save this key.
    // See also Encrypting with DES Using a Pass Phrase.
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();

    // Create encrypter/decrypter class
    DesEncrypter encrypter = new DesEncrypter(key);

    // Encrypt
    String encrypted = encrypter.encrypt("Don't tell anybody!");

    // Decrypt
    String decrypted = encrypter.decrypt(encrypted);
} catch (Exception e) {
}