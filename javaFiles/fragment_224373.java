public static void copy(InputStream is, OutputStream os) throws IOException {
    byte[] buff = new byte[1024*1024];
    int a = 0;
    while((a = is.read(buff)) > -1) {

        // a is the number of bytes ACTUALLY read, so 
        // when we write, that's the number of bytes to write
        os.write(buff,0,a);
    }
    os.flush();
}