public class Node
{
    String key;
    Node left, right;

    public Node(String entry)
    {
        key = entry;
        left = right = null;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }

    public Node getKey(String entry)
    {
        if(this.key.equals(key))
        {
            return this;
        }

        if(entry.compareTo(this.key) < 0)
        {
            return left == null ? null : left.getKey(entry);
        }
        else
        {
            return right == null ? null : right.getKey(entry);
        }
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }
}