byte[] in = out.getBytes();
byte[] base64Decoded = Base64.getDecoder().decode(in);

Key aesKey = new SecretKeySpec("API-KEY".getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, aesKey);
byte[] applicationIdDecrypted = cipher.doFinal(base64Decoded);

String applicationId= new String(applicationIdDecrypted);