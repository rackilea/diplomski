//RSA public key from DER encoded data
byte publicKeyData[] = ...;
X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyData);
KeyFactory kf = KeyFactory.getInstance("RSA");
PublicKey publicKey = kf.generatePublic(keySpec );

//RSA from modulus and exponent
RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, publicExponent);
KeyFactory kf = KeyFactory.getInstance("RSA");
PublicKey publicKey = kf.generatePublic(keySpec);

//Generate a key pair using a secure random algorithm
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
keyGen.initialize(2048, random);
KeyPair pair = keyGen.generateKeyPair();
PrivateKey privateKey = pair.getPrivate();
PublicKey publicKey = pair.getPublic();
byte publicKeyData[] = publicKey.getEncoded();