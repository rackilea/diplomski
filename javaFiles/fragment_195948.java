public String signData(final String data, final String privateKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(privateKeyString.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);


        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] sign = signature.sign();
        return new String(sign);
    }