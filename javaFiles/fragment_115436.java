public int read(byte[] b, int off, int len) throws IOException {
    if(off < 0 || len <= 0 || len > b.length - off) throw new IndexOutOfBoundsException();         
    int i = 0;
    while (i < len) {
        int j = read();
        if (j < 0) break; // Stop reading at EOF
        b[off + i] = (byte) j;
        i++;
    }
    if (i == 0) return -1; // If we get EOF with no data, return it to the caller
    else return i;
}