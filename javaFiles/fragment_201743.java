public int children(BinaryTreeNode<T> node) {
int children = 0;
if(node.getLeft() != null){
    children = 1 + children(node.getLeft());
}
else if(node.getRight() != null){
    children = children + 1 + children(node.getRight());

}
return children;