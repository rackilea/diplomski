private void assignFirst()
{
    BSTNode<E> node = root;
    while(node.left != null)
    {
        node = node.left;
    }
    first = node;
}