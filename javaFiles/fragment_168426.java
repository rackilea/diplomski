static long hmul(long x, long y) {
    long m32 = 0xffffffffL;
    // split
    long xl = x & m32;
    long xh = x >>> 32;
    long yl = y & m32;
    long yh = y >>> 32;
    // partial products
    long t00 = xl * yl;
    long t01 = xh * yl;
    long t10 = xl * yh;
    long t11 = xh * yh;
    // resolve sum and carries
    // high halves of t10 and t01 overlap with the low half of t11
    t11 += (t10 >>> 32) + (t01 >>> 32);
    // the sum of the low halves of t10 + t01 plus
    // the high half of t00 may carry into the high half of the result
    long tc = (t10 & m32) + (t01 & m32) + (t00 >>> 32);
    t11 += tc >>> 32;
    return t11;
}