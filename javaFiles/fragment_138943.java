public static PublicKey getPublicKey(CertificationRequest csr) throws IOException {
    SubjectPublicKeyInfo pubKeyInfo = csr.getCertificationRequestInfo().getSubjectPublicKeyInfo();
    RSAKeyParameters keyParams = (RSAKeyParameters) PublicKeyFactory.createKey(pubKeyInfo);
    KeySpec keySpec = new RSAPublicKeySpec(keyParams.getModulus(), keyParams.getExponent());

    try {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(keySpec);
    } catch (Exception e) {
        throw new IOException(e);
    }
}