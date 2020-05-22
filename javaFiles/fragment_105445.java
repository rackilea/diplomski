public static StringPair encrypt(String plainText) 
    throws GeneralSecurityException, UnsupportedEncodingException {

  // Note: this is a very confusing way to say 2048
  KeyPair kp = newKeyPair(1 << 11); 

  PublicKey pubKey = kp.getPublic();
  PrivateKey priKey = kp.getPrivate();
  byte[] cipherText = encryptWithPubKey(plainText.getBytes("UTF-8"), pubKey);

  // Here I return both items, to remove copy/paste problems
  StringPair result = new StringPair();
  result.encryptedText = new BASE64Encoder().encode(cipherText);
  result.key = new BASE64Encoder().encode(privKeyToBytes(priKey));
  return result;
}


private static class StringPair {
  public String encryptedText;
  public String key;
}


public static void main(String[] args) throws Exception {
  StringPair result = RSACrypto.encrypt("PLAIN TEXT");    
  System.out.println(RSACrypto.decrypt(result.encryptedText, result.key));       
}