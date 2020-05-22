public static long karatsuba(long x, long y){
    //base case:
    if (x < 10 || y < 10) return x * y;

    //length of digits:
    int xSize = String.valueOf(x).length();
    int ySize = String.valueOf(y).length();
    int halfN     = Math.max(xSize, ySize) / 2; // store N/2 instead of N
    int splitX = xSize - halfN;  // count the split point from xSize down
    int splitY = ySize - halfN;  // count the split point from ySize down

    //split each number in half (by length of digits):
    long numX_hi = Long.valueOf((String.valueOf(x).substring(0, splitX)));
    long numX_lo = Long.valueOf((String.valueOf(x).substring(splitX)));
    long numY_hi = Long.valueOf((String.valueOf(y).substring(0, splitY)));
    long numY_lo = Long.valueOf((String.valueOf(y).substring(splitY)));

    //solve multiplications recursively:
    long z0 = karatsuba(numX_lo,numY_lo);
    long z1 = karatsuba((numX_hi+numX_lo),(numY_hi+numY_lo));
    long z2 = karatsuba(numX_hi,numY_hi);

    //answer:
    return  (long)(z2 * Math.pow(10,halfN*2))  +  (long)((z1-z2-z0) * Math.pow(10,halfN))  +  (z0);
}