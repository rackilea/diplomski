//Case 4:Both Children
else
{
    Node minRightNode = deleteNode.right;
    while (minRightNode.left != null)
    {
        parent = minRightNode;
        minRightNode = minRightNode.left;
    }
 ... 
}