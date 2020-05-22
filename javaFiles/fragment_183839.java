public class GenericTree<T extends GenericTree<T, P, C>, P extends GenericTree<P, ?, T>, C extends GenericTree<C, T, ?>> {

    // Attributes
    private ArrayList<C> children = new ArrayList<C>();
    private P parent = null;

    // Methods
    public void setParent(P parent) {
        this.parent = parent;
    }

    public void addChild(C child) {
        @SuppressWarnings("unchecked")
        final T thisAsType = (T) this;
        child.setParent(thisAsType);
        this.children.add(child);
    }
}