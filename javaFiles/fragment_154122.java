private static char[] getTable(Charset cs) {
    if(cs.newEncoder().maxBytesPerChar() != 1f)
        throw new UnsupportedOperationException("Not an 8 bit charset");
    byte[] raw = new byte[256];
    IntStream.range(0, 256).forEach(i -> raw[i] = (byte)i);
    char[] table = new char[256];
    cs.newDecoder().onUnmappableCharacter(CodingErrorAction.REPLACE)
      .decode(ByteBuffer.wrap(raw), CharBuffer.wrap(table), true);
    for(int i = 0; i < 128; i++)
        if(table[i] != i) throw new UnsupportedOperationException("Not ASCII based");
    return table;
}