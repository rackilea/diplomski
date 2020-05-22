if (len <= 128) {
    out.write((byte)len);
} else {
    int bytes = 4 - Integer.numberOfLeadingZeroes(len) / 8;
    out.write(128 + bytes);
    for (int i = 0; i < bytes; ++i) {
        int b = len >>>(bytes - 1);
        out.write((byte)b); // Truncates the int to just 1 byte.
    }
}