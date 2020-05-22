public static byte[] decrypt(String encodedAndEncryptedData) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] encryptedData = Base64.getDecoder().decode(encodedAndEncryptedData);
    byte[] decryptedData = cipher.doFinal(encryptedData);                       
    return removePKCS7Padding(decryptedData, 16);  
}