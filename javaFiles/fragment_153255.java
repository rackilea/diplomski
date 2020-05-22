Collections.sort(testData, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return SortOrderEnum.valueOf(s1).compareTo(SortOrderEnum.valueOf(s2));
    }
});