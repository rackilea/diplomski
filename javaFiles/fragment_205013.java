double d = 1.555d;
System.out.println("d=" + d);
d = roundToTwoPlaces(d);
System.out.println("after rounding d=" + d);

public static double roundToTwoPlaces(double d) {
    return ((long) (d < 0 ? d * 100 - 0.5 : d * 100 + 0.5)) / 100.0;
}