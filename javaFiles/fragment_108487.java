try { 
  AES aes = new AES();
  byte[] encrypt = aes.encrypt(msg, key);
} 
catch(Exception e) { 
   e.printStackTrace(); 
}