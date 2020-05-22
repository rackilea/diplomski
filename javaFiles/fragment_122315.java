// raw estimation how many output digits we will need.
    // This is just enough in cases like BASE-1, and up to
    // 30 digits (for base 2) too much for something like (1,0,0).
    int len = (int) (Math.log(BASE) / Math.log(radix) * digits.length)+1;
    int[] rDigits = new int[len];
    int rIndex = len-1;
    int[] current = digits;
    int quotLen = digits.length;