public interface TreeNode<T> {
    TreeNode<T> getParent();
    void setParent(TreeNode<T> parent);

    List<TreeNode<T>> getChildren();
    void setChildren(List<TreeNode<T>> children);

    T getData();
    void setData(T data);
}