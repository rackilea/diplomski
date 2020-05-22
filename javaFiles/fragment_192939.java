System.out.println("d-f= " +  roundTo6Places(d - f));
System.out.println("d/f= " +  roundTo6Places(d / f));
System.out.println("(d-f)*(d-f)= " +  roundTo6Places((d - f) * (d - f)));

public static double roundTo6Places(double d) {
    return (long)(d * 1e6 + (d > 0 ? 0.5 : -0.5)) / 1e6;
}