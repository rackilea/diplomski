Collections.sort(rowItems, new Comparator<RowItem>() {
    @Override
    public int compare(RowItem r1, RowItem 2) {
        return r1.getStartDate().compareTo(r2.getStartDate());
    }
});