List<String> files = new ArrayList<String>();
files.add("42345_20131224091824545.zip");
files.add("12345_20131224091824145.zip");

Collections.sort(files, new Comparator<String>() {
    public int compare(String o1, String o2) {
        String s1 = o1.substring(6, 21);
        String s2 = o1.substring(6, 21);
        return s1.compareTo(s2);
    }
});