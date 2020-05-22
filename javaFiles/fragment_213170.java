Collections.sort(items,  new Comparator<String>() {
    private Pattern p = Pattern.compile("(\d+)[A-Z]*)");
    public int compare(String o1, String o2) {
        Matcher m1 = p.matcher(o1);
        Matcher m2 = p.matcher(o2);

        return Integer.valueOf(m1.group(0)).compareTo(Integer.valueOf(m2.group(0)));
    }
});