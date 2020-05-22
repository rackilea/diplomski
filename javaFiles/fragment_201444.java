private static class ItemsList extends AbstractList<Item> {

    private final List<Item> data = new ArrayList<>();

    @Override
    public Item get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }

    private void updateFromIndex(int index) {
        int size = size();

        for (; index < size; index++) {
            data.get(index).index.set(index);
        }
    }

    @Override
    public Item remove(int index) {
        Item result = data.remove(index);
        updateFromIndex(index);
        return result;
    }

    @Override
    public void add(int index, Item element) {
        data.add(index, element);
        updateFromIndex(index);
    }

    @Override
    public Item set(int index, Item element) {
        element.index.set(index);
        return data.set(index, element);
    }

}