public int readNBytes(byte[] b, int off, int len) throws IOException {
    Objects.requireNonNull(b);
    if (off < 0 || len < 0 || len > b.length - off)
        throw new IndexOutOfBoundsException();
    int n = 0;
    while (n < len) {
        int count = read(b, off + n, len - n);
        if (count < 0)
            break;
        n += count;
    }
    return n;
}