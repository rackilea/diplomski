Long aD = 2147483647L;
    //encode
    Long aE = (aD >> 31) ^ (aD << 1);
    //decode
    Long bD = (aE >> 1) ^ -(aE & 1);

    System.out.println(aD + "," + aE + "," + bD);