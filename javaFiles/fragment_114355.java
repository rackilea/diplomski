public static String str(final Object object) {
    return object == null ? "" : object.toString();
}

public static String str(final Double d) {
    return d == null ? "" : str(d.doubleValue());
}

public static String str(final double d) {
    return d < 0.001 ? String.format("%.10f", d) : String.valueOf(d);
}