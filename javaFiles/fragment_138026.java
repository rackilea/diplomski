public static ECPublicKey genEcPubKey() throws Exception {
    KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
    java.security.PublicKey ecPublicKey = (ECPublicKey) factory
            .generatePublic(new X509EncodedKeySpec(Helper
                    .toByte(ecRemotePubKey))); // Helper.toByte(ecRemotePubKey)) is java.security.PublicKey#getEncoded()
    return (ECPublicKey) ecPublicKey;
}