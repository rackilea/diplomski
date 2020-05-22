Key aesKey = new SecretKeySpec("API-KEY".getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, aesKey);

byte[] applicationIdEncrypted = cipher.doFinal(applicationId.getBytes());
byte[] base64Encoded = Base64.getEncoder().encode(applicationIdEncrypted);

String out = new String(base64Encoded);