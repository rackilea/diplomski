public static BigInteger customPowMod(BigInteger a, BigInteger b, BigInteger n){
    BigInteger previous = a.mod(n);
    BigInteger runningTotal = new BigInteger("1");
    for(int i = 0; i < a.bitLength(); i++){
        if(a.testBit(i)){
            runningTotal = runningTotal.multiply(previous);
        }
        previous = previous.multiply(previous).mod(n);
    }
    return runningTotal.mod(n);
}