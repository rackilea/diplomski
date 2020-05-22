public static String formattedFloat(float f) {
    return String.format("%s %.1f", f >= 0 ? "+" : "-", Math.abs(f));
}

// Example
System.out.println(formattedFloat(-2.21234f);
// prints "- 2.2"
System.out.println(formattedFloat(6f);
// prints "+ 6.0"