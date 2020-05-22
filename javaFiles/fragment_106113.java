public class TreeNode
{
    private TreeNode leftNode;
    private TreeNode rightNode;
    private int data;

    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode)
    {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode()
    {
        return leftNode;
    }
    public TreeNode getRightNode()
    {
        return rightNode;
    }
    public int getData()
    {
        return data;
    }
}