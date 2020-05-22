static BigInteger twoToThePower(BigInteger n){
        BigInteger eight = BigInteger.valueOf(8);
        BigInteger[] devideResult = n.divideAndRemainder(eight);
        BigInteger bufferSize = devideResult[0].add(BigInteger.ONE);
        int  offset = devideResult[1].intValue();
        byte[] buffer = new byte[bufferSize.intValueExact()];
        buffer[0] = (byte)(1 << offset);
        return new BigInteger(1,buffer);
    }