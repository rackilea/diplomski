/**
 * reads a public key from a file
 * @param filename name of the file to read
 * @param algorithm is usually RSA
 * @return the read public key
 * @throws Exception
 */
public  PublicKey getPemPublicKey(String filename, String algorithm) throws Exception {
      File f = new File(filename);
      FileInputStream fis = new FileInputStream(f);
      DataInputStream dis = new DataInputStream(fis);
      byte[] keyBytes = new byte[(int) f.length()];
      dis.readFully(keyBytes);
      dis.close();

      String temp = new String(keyBytes);
      String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----\n", "");
      publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");


      BASE64Decoder b64 = new BASE64Decoder();
      byte[] decoded = b64.decodeBuffer(publicKeyPEM);

      X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
      KeyFactory kf = KeyFactory.getInstance(algorithm);
      return kf.generatePublic(spec);
}