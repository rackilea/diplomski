class test {
    private static Pattern pd = Pattern.compile("(\")((?:[^\"]|\"\")*)\"");
    private static Pattern ps = Pattern.compile("(')((?:[^']|'')*)'");
    public static Matcher match(String s) {
        Matcher md = pd.matcher(s);
        if (md.matches()) return md;
        else return ps.matcher(s);
    }
}