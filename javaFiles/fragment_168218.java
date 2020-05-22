long FNV64Hash(String inString) throws UnsupportedEncodingException {
    // FNV-64 constants.
    long FNVprime = 1099511628211L;

    // Needs workround for unsigned 64-bit: 14695981039346656037.
    long FNVbasis = (146959810393466560L * 100L) + 37L;
    // Alternative: long FNVbasis = -3750763034362895579L;

    // Convert string to bytes.
    byte[] bytes = inString.getBytes("UTF-8"); // Specify a character encoding.

    long hash = FNVbasis;
    for (byte aByte : bytes) {
        hash ^= aByte;
        hash *= FNVbasis;
    }
    return hash;
} // end FNV64Hash()