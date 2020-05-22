public static String decryptString(String hash){
    encryptor = new StandardPBEStringEncryptor();
    encryptor.setAlgorithm("PBEWithMD5AndTripleDES"); 
    encryptor.setPassword("ABXY");
    return encryptor.decrypt(hash);
}