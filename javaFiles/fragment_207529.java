public static BigInteger[][] exponential(BigInteger[][] fibonacciMatrix, long nTerm)
{
    long l;
    BigInteger[][] rgbiFibonacci = {{BigInteger.ONE, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ONE}};
    while (nTerm > 0) {
        if (nTerm % 2 == 1) {
            rgbiFibonacci = multiplyMatrix(rgbiFibonacci, fibonacciMatrix);
        }
        fibonacciMatrix = multiplyMatrix(fibonacciMatrix, fibonacciMatrix);
        nTerm /= 2;
    }
    return (rgbiFibonacci);
}//end exponential(BigInteger[][], long)