List<PositionalItem> items = new ArrayList<>();
items.addAll(vertical);
items.addAll(horizontal);
items.addAll(ad);

Collections.sort(items, new Comparator<PositionalItem>() {
    @Override
    public int compare(PositionalItem lhs, PositionalItem rhs) {
        return Integer.compare(lhs.getPosition(), rhs.getPosition());
    }
});