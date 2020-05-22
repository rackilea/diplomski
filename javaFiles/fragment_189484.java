public final class Example {

    private final List<Integer> list;

    public Example(List<? extends Integer> list) {
        this.list = new ArrayList<Integer>(list);
    }

    public List<Integer> getList() {
        return new ArrayList<Integer>(list);
    }
}