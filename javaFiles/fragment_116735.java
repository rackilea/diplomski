new Comparator<String>() {
    Pattern p = Pattern.compile("([0-9]+)[a-zA-Z]+");

    private String getNum(String s) {
        Matcher m = p.matcher(s);
        return m.matches() ? m.group(1) : s;
    }

    @Override
    public int compare(String o1, String o2) {
        o1 = getNum(o1);
        o2 = getNum(o2);
        return Integer.compare(Integer.parseInt(o1),
                               Integer.parseInt(o2));
    }
};