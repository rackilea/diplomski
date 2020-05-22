public static String formatScientific(double val) {
    // Default case.
    String out = String.format("%1.6f", val);

    // Use scientific notation on values greater than 10. 
    if (val >= 10)
        out = String.format("%1.2e", val).replaceAll("\\+", "").concat("0");

    return out;
}