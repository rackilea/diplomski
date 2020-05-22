Comparator<String> myComparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        if (s1==null && s2==null) return 0;//swapping has no point here
        if (s1==null) return  1;
        if (s2==null) return -1;
        return s1.compareTo(s2);
    }
};