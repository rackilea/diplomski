public String encryptText(String plainText) throws ... {
    byte[] plainTextBytes = plainText.getBytes("UTF8");
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec); 
    byte[] encrypted = cipher.doFinal(plainTextBytes);
    return toHex(encrypted);
}

public String decryptText(String cipherTextString) throws ... {
    byte[] cipherTextBytes = fromHex(cipherTextString);
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
    byte[] plainTextBytes = cipher.doFinal(cipherTextBytes);
    return new String(plainTextBytes, "UTF8");
}