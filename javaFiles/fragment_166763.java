public static void outputDegreesF(double degreesC) {
    double fahrenheit = 32.0 + (degreesC * 9.0 / 5.0);

    System.out.print(degreesC + " " + fahrenheit); // Easier
    // Or
    System.out.printf("%.7f %.7f", degreesC, fahrenheit); // Used more and lets you format
}