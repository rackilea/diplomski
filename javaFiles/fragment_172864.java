static void copy(String src, String dest) throws IOException {
    boolean done = false;
    try (InputStream in = new FileInputStream(src)) {
        try(OutputStream out = new FileOutputStream(dest)) {
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
        done = true;
    } catch(IOException e) {
        if (!done)
            throw e;
    }
}