public static final long copyInputToOutput(InputStream input, OutputStream output, long startIdx, long endIdx) throws IOException {
    final long maxread = 24*1024;
    byte[] buffer = new byte[(int)maxread];
    input.skip(startIdx);
    long written=0;
    long remaining = endIdx-startIdx+1;
    while(remaining>0) {
        int read = input.read(buffer, 0, (int)Math.min(maxread, remaining));
        output.write(buffer, 0, read);
        remaining -= read;
        written += read;
    }
    output.flush();
    return written;
}