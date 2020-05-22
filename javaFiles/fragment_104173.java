public static String encrypt(byte[] plainData) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] plainDataPKCS7Padded = addPKCS7Padding(plainData, 16); 
    byte[] encryptedData = cipher.doFinal(plainDataPKCS7Padded);  
    return Base64.getEncoder().encodeToString(encryptedData);
}