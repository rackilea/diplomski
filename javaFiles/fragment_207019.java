public interface Node<T, N extends Node<T, N>> {
    T getValue();
    List<N> getNeighbors();
    void addNodes(List<N> nodes);
}

public interface TreeNode<T> extends Node<T, TreeNode<T>> {
    List<TreeNode<T>> getChildren();
    void addChildren(List<TreeNode<T>> treeNodes);

    @Override
    default List<TreeNode<T>> getNeighbors() {
        return getChildren();
    }

    @Override
    default void addNodes(List<TreeNode<T>> nodes) {
        addChildren(nodes);
    }
}