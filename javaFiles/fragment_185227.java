public static double parseDouble(String s) throws NumberFormatException {
    return FloatingDecimal.readJavaFormatString(s).doubleValue();
}

public static Double valueOf(String s) throws NumberFormatException {
    return new Double(FloatingDecimal.readJavaFormatString(s).doubleValue());
}