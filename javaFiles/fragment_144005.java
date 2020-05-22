KeyFactory kf = KeyFactory.getInstance("RSA");
RSAPrivateKeySpec priv = kf.getKeySpec(privateKey, RSAPrivateKeySpec.class);

RSAPublicKeySpec keySpec = new RSAPublicKeySpec(priv.getModulus(), BigInteger.valueOf(65537));

PublicKey publicKey = kf.generatePublic(keySpec);