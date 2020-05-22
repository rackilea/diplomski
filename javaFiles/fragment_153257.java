Collections.sort(testData, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return SORT_ORDER.get(s1).compareTo(SORT_ORDER.get(s2));
    }
});