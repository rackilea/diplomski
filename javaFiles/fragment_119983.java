Collections.sort(yourList, new Comparator<String>() {
    public int compare(String s1, String s2) {
        double d1 = Double.valueOf(s1.substring(s1.lastIndexOf(' ') + 1));
        double d2 = Double.valueOf(s2.substring(s2.lastIndexOf(' ') + 1));
        return Double.compare(d1, d2);
    }
});