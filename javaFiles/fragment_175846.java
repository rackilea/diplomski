public String read(InputStream is) throws ReadException {
    ByteArrayOutputStream w = new ByteArrayOutputStream();
    try {
        int mLen = readUnsignedInt(is);
        for (int i = 0; i < mLen ; i++) {
            int nByte= is.read();
            w.write(nByte);
        }  // carry on