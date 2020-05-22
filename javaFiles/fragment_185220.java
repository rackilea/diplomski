public static String format(double num, double places) {
    String format = "#.";
    for(int i=0; i<places; i++) format += "0";
    DecimalFormat df = new DecimalFormat(format);
    return df.format((int)(num * Math.pow(10, places)) / (double) Math.pow(10, places));
}