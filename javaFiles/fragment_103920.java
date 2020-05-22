KeyPair keyPair = new KeyPair(KeyPair.ALG_EC_FP, KeyBuilder.LENGTH_EC_FP_256);
ECPublicKey pub = (ECPublicKey) keyPair.getPublic();
ECPrivateKey priv = (ECPrivateKey) keyPair.getPrivate();
pub.setW(pubBytes, (short) 0, (short) pubBytes.length);
priv.setS(privBytes, (short) 0, (short) privBytes.length);
//do not forget to set parameters of your curve to both private and public key HERE!!!