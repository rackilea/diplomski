public static int mIndex(String x) {
    Matcher m = Pattern.compile("[mM]").matcher(x);
    if (m.find())
        return m.start();
    return -1;
}