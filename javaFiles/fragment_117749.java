String input = "abcdef";

byte[] key = new byte[16];
(new SecureRandom()).nextBytes(key);

Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
byte[] ciphertext = cipher.doFinal(input.getBytes());
byte[] iv = cipher.getIV();
GCMParameterSpec gcmspec = cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
System.out.println("ciphertext: " + ciphertext.length + ", IV: " + iv.length + ", tLen: " + gcmspec.getTLen());

cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
byte[] plaintext = cipher.doFinal(ciphertext);

System.out.println("plaintext : " + new String(plaintext));