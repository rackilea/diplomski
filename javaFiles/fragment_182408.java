double a = -0.0;
    double b = +0.0;
    System.out.println("a == b? " + (a == b)); // true
    long aLong = Double.doubleToLongBits(a);
    long bLong = Double.doubleToLongBits(b);
    System.out.println("a' >= b'? " + (aLong >= bLong)); // false