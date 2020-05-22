for (;;) {
    int b = source.read();
    // Single byte character starting with binary 0.
    if ((b & 0x80) == 0)
        return (char) b;
    // 2-byte character starting with binary 110.
    if ((b & 0xE0) == 0xC0)
        return (char) ((b & 0x1F) << 6 | source.read() & 0x3F);
    // 3 and 4 byte encodings left as an exercise...
    // 2nd, 3rd, or 4th byte of a multibyte char starting with 10. 
    // Back up and loop.
    if ((b & 0xC0) == 0xF0) 
        source.seek(source.getFilePosition() - 2);
}