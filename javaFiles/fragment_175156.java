public void write(String str, int offset, int count) throws IOException {
    if ((offset | count) < 0 || offset > str.length() - count) {
        throw new StringIndexOutOfBoundsException(str, offset, count);
    }
    char[] buf = new char[count];
    str.getChars(offset, offset + count, buf, 0);
    synchronized (lock) {
        write(buf, 0, buf.length);
    }
}