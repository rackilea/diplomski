// your 2 binary strings
        String aBin = "100001";
        String bBin = "111110";

        // convert them to int
        int a = Integer.parseInt(aBin, 2);
        int b = Integer.parseInt(bBin, 2);

        // Do the math you want and store the result on 'r'
        int r = a * b;

        // If you want, convert the result to the binary string format
        String rBin = Integer.toBinaryString(r);