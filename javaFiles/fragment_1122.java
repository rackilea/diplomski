static class Tree<T> {
    private T value;
    private final Tree<T> left;
    private final Tree<T> right;

    public Tree(T v, Tree<T> l, Tree<T> r) {
        this.value = v;
        this.left = l;
        this.right = r;
    }

    public T getValue() {
        return this.value;
    }

    // getters ...

}