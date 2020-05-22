@Test
public void decryptBlazemeterJwt() {
    try {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pk = kf.generatePrivate(spec);
        EncryptedJWT jwt = EncryptedJWT.parse(tokenString);
        RSADecrypter decrypter = new RSADecrypter(pk);
        jwt.decrypt(decrypter);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        Assert.fail();
    }
}