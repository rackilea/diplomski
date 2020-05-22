try {
    cryptoSha dc = new cryptoSha();
    String nhash = dc.stringHash("test");
} catch (NoSuchAlgorithmException ex) {
    ex.printStackTrace();
}