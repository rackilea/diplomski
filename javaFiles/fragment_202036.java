public void MD5(BufferedInputStream in, Key pubKey) throws Exception{
    Mac md = Mac.getInstance("HmacMD5");
    md.init(pubKey);
    byte[] contents = new byte[1024];
    int readSize;
    while ((readSize = in.read(contents)) != -1) {
        md.update(contents, 0, readSize);
    }
    byte[] hashValue = md.doFinal();
}