public static void main(String[] args) {
    System.out.println("Temperature Conversion Table");
    System.out.println("____________________________");
    System.out.println("  Fahrenheit      Celsius  ");

    // From 94F to 104F, with increments of 0.5F
    for (double fhdeg = 94.0; fhdeg < 104.5; fhdeg += 0.5) {
        // Calculate degree in Celsius by calling the celsiusFromFahrenheit method
        double celdeg = celsiusFromFahrenheit(fhdeg);
        // Display degrees in Fahrenheit and in Celsius
        System.out.printf( "    %.2f           %.2f\n", fhdeg, celdeg);
    }
}

static double celsiusFromFahrenheit(double fhdeg) {
    return (5. / 9.) * fhdeg - 32;
}