/* Client: */
byte[] encrypted = cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));
String text = DatatypeConverter.printBase64Binary(encrypted);
…

/* Server: */
byte[] encrypted = DatatypeConverter.parseBase64Binary(data);
byte[] decrypted = Cipher.doFinal(encrypted);
System.out.println(new String(decrypted, StandardCharsets.UTF_8);