public void add(E value)
{
    this.root = add(root, value, root, null);
    assignFirst();
}
// post: value added to tree so as to preserve binary search tree
private BSTNode<E> add(BSTNode<E> node, E value, BSTNode<E> parent, BSTNode<E> prev)
{
    if (node == null)
    {
        node = new BSTNode<E>(value);
        node.parent = parent;
        if(prev == null)
        {
            node.next = parent;
        }
        else
        {
            node.next = prev.next;
            prev.next = node;
        }
        this.numElements++;
    }
    else if (node.data.compareTo(value) > 0)
    {
        node.left = add(node.left, value, node , getPrevNode(node));
    }
    else if (node.data.compareTo(value) < 0)
    {
        node.right = add(node.right, value, node, node);
    }
    return node;
}