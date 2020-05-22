class Ol extends ModifiableObservableListBase<Integer> {

    private final List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8));

    @Override
    public Integer get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doAdd(int index, Integer element) {
        list.add(index, element);
    }

    @Override
    protected Integer doSet(int index, Integer element) {
        return list.set(index, element);
    }

    @Override
    protected Integer doRemove(int index) {
        return list.remove(index);
    }

    public void modify() {
        if (size() < 4) {
            throw new IllegalStateException();
        }
        beginChange();
        set(0, 3);
        set(3, 7);
        endChange();
    }

}