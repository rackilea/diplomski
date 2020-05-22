Collections.sort(items, new Comparator<Item>() {
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getPrice() == item2.getPrice()) {
            return 0;
        } else if (item1.getPrice() > item2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    }
});