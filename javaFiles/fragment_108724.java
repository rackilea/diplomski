class ItemList implements Iterable<ItemList.Entry> {

    private List<Entry> entries;

    public static class Entry {
        private final String id = null;
        private int quantity;     
    }

    @Override public Iterator<Entry> iterator() {
        return entries.iterator();
    }
}