// your 2 binary strings
        String aBin = "100001";
        String bBin = "111110";

        // convert them to BigInteger
        BigInteger a = new BigInteger(aBin, 2);
        BigInteger b = new BigInteger(bBin, 2);

        // Do the math you want and store the result on 'r'
        BigInteger r = a.multiply(b);

        // If you want, convert the result to the binary string format
        String rBin = r.toString(2);