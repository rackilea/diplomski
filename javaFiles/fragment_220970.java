static void createTrustStore(Path certificate, Path keystore, char[] password)
        throws IOException, GeneralSecurityException {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate root;
    try (InputStream is = Files.newInputStream(certificate)) {
        root = cf.generateCertificate(is);
    }
    KeyStore pkcs12 = KeyStore.getInstance("PKCS12");
    pkcs12.load(null, null);
    pkcs12.setCertificateEntry("root", root);
    try (OutputStream os = Files.newOutputStream(keystore, StandardOpenOption.CREATE_NEW)) {
        pkcs12.store(os, password);
    }
}

private static final byte[] HEADER = "-----".getBytes(StandardCharsets.US_ASCII);

static void createIdentityStore(Path certificate, Path key, Path keystore, char[] password)
        throws IOException, GeneralSecurityException {
    byte[] pkcs8 = decode(Files.readAllBytes(key));
    KeyFactory kf = KeyFactory.getInstance("RSA");
    PrivateKey pvt = kf.generatePrivate(new PKCS8EncodedKeySpec(pkcs8));
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate pub;
    try (InputStream is = Files.newInputStream(certificate)) {
        pub = cf.generateCertificate(is);
    }
    KeyStore pkcs12 = KeyStore.getInstance("PKCS12");
    pkcs12.load(null, null);
    pkcs12.setKeyEntry("identity", pvt, password, new Certificate[] { pub });
    try (OutputStream s = Files.newOutputStream(keystore, StandardOpenOption.CREATE_NEW)) {
        pkcs12.store(s, password);
    }
}

private static byte[] decode(byte[] raw) {
    if (!Arrays.equals(Arrays.copyOfRange(raw, 0, HEADER.length), HEADER)) return raw;
    CharBuffer pem = StandardCharsets.US_ASCII.decode(ByteBuffer.wrap(raw));
    String[] lines = Pattern.compile("\\R").split(pem);
    String[] body = Arrays.copyOfRange(lines, 1, lines.length - 1);
    return Base64.getDecoder().decode(String.join("", body));
}