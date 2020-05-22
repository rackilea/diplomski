public static Short valueOf(short s) {
        final int offset = 128;
        int sAsInt = s;
        if (sAsInt >= -128 && sAsInt <= 127) { // must cache
                return ShortCache.cache[sAsInt + offset];
        }
        return new Short(s);
    }