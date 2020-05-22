String pubk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBYu61cljDpI+XdWPO1bi5Ricv5+U/4u9Mqj4SdWp8YnCr3FaXTphW5mJol9KdqzK50GmD0Kv1x4z5gz6TDayfn527FX9KEO/puFlPiIkik2lg5UP9vGIyeWKoaxw1S8skjW13Md+Lw4i9ZqeoI9boLVMJdxMCtS+MTVDNxwDShwIDAQAB";
byte[] bPubk = Base64.getDecoder().decode(pubk);

try {
    KeyFactory kf = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bPubk);
    PublicKey key = kf.generatePublic(publicKeySpec);
    System.out.println(key);
} catch (Exception e) {
    System.err.println(e.getMessage());
}