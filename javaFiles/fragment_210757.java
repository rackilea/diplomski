String pubKey = "tihq/Gk3OUs5NzP+XTRKXBwSxHtB0TWn0RREcpXEtp316tyD9DzKaIbdKexb/mRr"; //64 caratteri
String exponent = "AQAB";

byte[] keyBytes = Base64.decode(pubKey,Base64.DEFAULT);
byte[] exponentByte = Base64.decode(exponent,Base64.DEFAULT);

KeyFactory keyFactory = KeyFactory.getInstance("RSA");

RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(keyBytes), new BigInteger(exponentByte));
RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);