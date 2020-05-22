public static int readUnsignedInt(InputStream in) throws IOException {
    int b = in.read();
    int i = b & 0x7F;
    for (int shift = 7; (b & 0x80) != 0; shift += 7) {
        b = in.read();
        i |= (b & 0x7FL) << shift;
    }
    return i;
}