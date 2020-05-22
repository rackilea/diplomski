public void decrypt(File in, File out) throws IOException, InvalidKeyException {
    aesCipher.init(Cipher.DECRYPT_MODE, aeskeySpec);
    CipherInputStream is = new CipherInputStream(new FileInputStream(in), aesCipher);
    FileOutputStream os = new FileOutputStream(out);

    int i;
    byte[] b = new byte[1024];
    while((i=is.read(b))!=-1) {
            os.write(b, 0, i);
    }