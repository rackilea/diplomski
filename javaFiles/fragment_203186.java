public static PemObject createPrivateObject(KeyPair key) throws Exception {
  return new PemObject("PRIVATE KEY", key.getPrivate().getEncoded());
}

[...]

public static KeyPair readKeyPair(String path) {
  File privateKeyFile = new File(path);
  try (PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile))){

    PrivateKeyInfo privkeyInfo = (PrivateKeyInfo)pemParser.readObject();
    PKCS8EncodedKeySpec keyspec = new PKCS8EncodedKeySpec(privkeyInfo.getEncoded);
    RSAPrivateKey privKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keyspec)
    pemParser.close();
    return kp;

} catch { ....