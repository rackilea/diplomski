public void pump(InputStream in, OutputStream out, int size) {
    byte[] buffer = new byte[4096]; // Or whatever constant you feel like using
    int done = 0;
    while (done < size) {
        int read = in.read(buffer);
        if (read == -1) {
            throw new IOException("Something went horribly wrong");
        }
        out.write(buffer, 0, read);
        done += read;
    }
    // Maybe put cleanup code in here if you like, e.g. in.close, out.flush, out.close
}