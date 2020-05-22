sorter.setComparator(1, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.substring(0, Math.min(o1.length(), 5)).compareTo(o2.substring(0, Math.min(o2.length(), 5)));
    }
});