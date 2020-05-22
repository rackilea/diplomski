class Node
{
    Node _left, _right;

    public Node(Node left, Node right)
    {
        _left = left != null ? new Node(left._left, left._right) : null;
        _right = right != null ? new Node(right._left, right._right) : null;
    }
}