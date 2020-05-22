BigInteger modulus = new BigInteger(Base64.getDecoder().decode(modulusAsString));
BigInteger exponent =  new BigInteger(Base64.getDecoder().decode(exponentAsString));

RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);
KeyFactory keyFactory = KeyFactory.getInstance("RSA");
PublicKey pubKey =keyFactory.generatePublic(keySpec);