long m = (1L << 21) - 1;
    System.out.println(m*m*m);                  // 9223358842721533951
    System.out.println(m*m*m < Long.MAX_VALUE); // true

    long n = m + 1;
    System.out.println(n*n*n);                  // -9223372036854775808