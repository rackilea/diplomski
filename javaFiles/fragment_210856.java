public static BigInteger recursivePower (BigInteger base, BigInteger exp) {
    if (exp.compareTo(BigInteger.ZERO) == 0) 
        return BigInteger.ONE;
    if (exp.compareTo(BigInteger.ONE) == 0)
        return base;
    if (exp.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
        BigInteger temp = recursivePower(base, exp.divide(BigInteger.valueOf(2)));
        return temp.multiply(temp);
    }
    BigInteger temp = recursivePower(base, (exp.subtract(BigInteger.valueOf(1)).divide(BigInteger.valueOf(2))));
    return temp.multiply(temp).multiply(base);
}

public static void main(String []args){
    System.out.println(recursivePower(BigInteger.valueOf(2), BigInteger.valueOf(80)).toString());
 }