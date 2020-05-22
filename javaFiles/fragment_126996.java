/**
 * equals to java.io.DatainputStream.readFully
 */
public static void readFully(InputStream in, byte b[], int off, int len) throws IOException {
    if (len < 0) {
        throw new IndexOutOfBoundsException();
    }
    int n = 0;
    while (n < len) {
        final int count = in.read(b, off + n, len - n);
        if (count < 0) {
            throw new EOFException();
        }
        n += count;
    }
}    

public static int readByte (byte [] bytes, int offset) {
    return ((int) bytes [offset]) & 0xFF;
}

public static short readShort(byte [] bytes, int offset) {
    return (short)
        (readByte(bytes, offset) << 8 |
         readByte(bytes, offset + 1));
}