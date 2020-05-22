int read( byte result[], int offset, int size ) {
    if (offset == 0)
        return read(result, size);
    byte[] buf = new byte[size];
    int bytesRead = read(buf, size);
    System.arraycopy(buf, 0, result, offset, bytesRead);
    return bytesRead;
}