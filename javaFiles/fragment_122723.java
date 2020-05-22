class BaseList implements Iterable<Base> {
    private List<Base> list = new ArrayList<>();

    public boolean add(Select s) {
        return list.add(s);
    }

    public boolean add(Ast a) {
        return list.add(a);
    }

    public boolean add(Gt gt) {
        return list.add(gt);
    }

    @Override
    public Iterator<Base> iterator() {
        return Collections.unmodifiableList(list).iterator();
    }
}