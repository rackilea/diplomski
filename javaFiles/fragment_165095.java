public static void main(String[] args) throws GeneralSecurityException, IOException {
        String pemString = "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCnwiV6Opd+3TZf9N1z9GVhxtY\nnqWiFRIsqUOR/vXXge8hbhgm5ITKfZtvyO92Lk+5Tl1Qdrb+OfNcKmBHkGUEdBib\nXCNEXj7SOhQTBH0PnV++8+xJXoutsiJU9Z+sjMCFivbd5wgBizXcY8U9SQfYb+Iv\nNQ8FBL4nV8lMiwAp8QIDAQAB\n-----END PUBLIC KEY-----\n";
        String base64 = toBase64DER(pemString);
        PublicKey publicKey = loadPublicKey(base64);
}

public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException {
        byte[] data = Base64.getDecoder().decode(stored.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
}

public static String toBase64DER(String pem) {
    return pem.substring(0, pem.lastIndexOf("\n")) //remove last \n
            .substring(pem.indexOf('\n') + 1) //remove first line
            .substring(0, pem.lastIndexOf("\n") + 1) //remove last line
            .replace("\n", ""); // remove all \n occurences
}