Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }
};
Set<String> set = new TreeSet<>(comparator);