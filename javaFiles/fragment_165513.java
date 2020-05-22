public static String generateSasSignature(String key, String input) {
    SecretKeySpec secret_key = new SecretKeySpec(Base64.getDecoder().decode(key), "HmacSHA256");
    Encoder encoder = Base64.getEncoder();
    Mac sha256_HMAC = null;
    String hash = null;

    try {
        sha256_HMAC = Mac.getInstance("HmacSHA256");
        sha256_HMAC.init(secret_key);
        hash = new String(encoder.encode(sha256_HMAC.doFinal(input.getBytes("UTF-8"))));
    }
    catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return hash;
}