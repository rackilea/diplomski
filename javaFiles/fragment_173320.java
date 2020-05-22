char[] password = /* ... */
byte[] salt = /* ... */
SecretKeyFactory kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
PBEKeySpec spec = new PBEKeySpec(password, salt, 8192, 256);
SecretKey tmp = kf.generateSecret(spec);
SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");