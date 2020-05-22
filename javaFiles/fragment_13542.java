static public byte[] calculateMessageDigest()
        throws NoSuchAlgorithmException, IOException {
    SHA1Digest md = new SHA1Digest();

    byte[] dataBytes = "helloooooooooooooo".getBytes();
    int nread = dataBytes.length;
    md.update(dataBytes, 0, nread);
    byte[] result = new byte[32];
    md.doFinal(result, 0);
    return result;