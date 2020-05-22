public static HashAlgorithm getHashAlgorithm(String s, int polynomial) {
        if ("crc8".equals(s)) {
            return new CRC8(polynomial);
        } else
        if ("crc16".equals(s)) {
            return new CRC16(polynomial);
        } else
        if ("crc32".equals(s)) {
            return new CRC32(polynomial);
        }
        throw new AssertionError("Unknown algorithm: " +s);
    }