long t = Long.parseUnsignedLong("1111111111111111111111111111111111111111111111111111111111010011", 2);

    long twoPower16 = Long.parseLong("1111111111111111", 2);

    long one = t & twoPower16;
    long two = t >> 16 & twoPower16;
    long thr = t >> 32 & twoPower16;
    long fou = t >> 48 & twoPower16;

    System.out.println(Long.toBinaryString(one));
    System.out.println(Long.toBinaryString(two));
    System.out.println(Long.toBinaryString(thr));
    System.out.println(Long.toBinaryString(fou));