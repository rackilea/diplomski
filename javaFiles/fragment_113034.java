public static Long valueOf(String s) throws NumberFormatException
{
    return Long.valueOf(parseLong(s, 10));
}

public static Long valueOf(long l) {
    final int offset = 128;
    if (l >= -128 && l <= 127) { // will cache 
        return LongCache.cache[(int)l + offset];
    }
    return new Long(l);
}