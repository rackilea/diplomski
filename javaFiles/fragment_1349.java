958    public static int compare(double d1, double d2) {
959        if (d1 < d2)
960            return -1;           // Neither val is NaN, thisVal is smaller
961        if (d1 > d2)
962            return 1;            // Neither val is NaN, thisVal is larger
963
964        long thisBits = Double.doubleToLongBits(d1);
965        long anotherBits = Double.doubleToLongBits(d2);
966
967        return (thisBits == anotherBits ?  0 : // Values are equal
968                (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
969                 1));                          // (0.0, -0.0) or (NaN, !NaN)
970    }