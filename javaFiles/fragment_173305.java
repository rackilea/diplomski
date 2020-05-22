public static boolean isInteger(BigDecimal bigDecimal) {
    int intVal = bigDecimal.intValue();
    return bigDecimal.compareTo(new BigDecimal(intVal)) == 0;
}

public static String myFormat(BigDecimal bigDecimal) {
    String formatPattern = isInteger(bigDecimal) ? "#,##0" : "#,##0.00";
    return new DecimalFormat(formatPattern).format(bigDecimal);
}