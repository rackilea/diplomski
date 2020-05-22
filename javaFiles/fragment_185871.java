try(InputStream in = new BufferedInputStream(new FileInputStream(name))){
    byte[] buf = new byte[4096 * 16];
    int c;
    int lineCount = 0;
    while ((c = in.read(buf)) > 0) {
       for (int i = 0; i < c; i++) {
           if (buf[i] == '\n') lineCount++;
       }
    }
}