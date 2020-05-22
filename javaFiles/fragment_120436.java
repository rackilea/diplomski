public static String encodePassword(String rawPass) {
    return new String(
        Base64.encodeBase64(digester.digest(rawPass.getBytes(StandardCharsets.UTF_8))),
        StandardCharsets.US_ASCII
    );
}