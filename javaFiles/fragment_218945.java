private static byte[] P256_HEAD = Base64.getDecoder().decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE");

/**
 * Converts an uncompressed secp256r1 / P-256 public point to the EC public key it is representing.
 * @param w a 64 byte uncompressed EC point consisting of just a 256-bit X and Y
 * @return an <code>ECPublicKey</code> that the point represents 
 */
public static ECPublicKey generateP256PublicKeyFromFlatW(byte[] w) throws InvalidKeySpecException {
    byte[] encodedKey = new byte[P256_HEAD.length + w.length];
    System.arraycopy(P256_HEAD, 0, encodedKey, 0, P256_HEAD.length);
    System.arraycopy(w, 0, encodedKey, P256_HEAD.length, w.length);
    KeyFactory eckf;
    try {
        eckf = KeyFactory.getInstance("EC");
    } catch (NoSuchAlgorithmException e) {
        throw new IllegalStateException("EC key factory not present in runtime");
    }
    X509EncodedKeySpec ecpks = new X509EncodedKeySpec(encodedKey);
    return (ECPublicKey) eckf.generatePublic(ecpks);
}