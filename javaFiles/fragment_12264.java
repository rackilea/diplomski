Collections.sort(rowItems, new Comparator<SearchRowItem>() {
    @Override
    public int compare(final SearchRowItem o1, final SearchRowItem o2) {
        int compare = o1.getName().compareToIgnoreCase(o2.getName());
        if (compare != 0) {
            return compare;
        }
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
});