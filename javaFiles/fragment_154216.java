try {
     keyPair = new KeyPair(KeyPair.ALG_RSA, KeyBuilder.LENGTH_RSA_2048);
} catch (CryptoException e) {
     short reason = e.getReason();
     ISOException.throwIt(reason);
}