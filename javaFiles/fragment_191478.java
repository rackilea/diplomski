public static int firstSignificant(double d) {
    return (int) Math.ceil(-Math.log10(d));
}

// Usage
System.out.println(firstSignificant(0.123456));    // 1
System.out.println(firstSignificant(0.0012345));   // 3
System.out.println(firstSignificant(0.000012345)); // 5