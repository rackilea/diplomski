public Node preOrderMod(Node temp)
{
    if (temp != null)
    {
        if (temp.left != null)
            return temp.left;

        if (temp.right != null)
            return temp.right;

        return mod(temp.parent);
    }

    return null;
}

private Node mod(Node temp)
{
    if (temp != null && temp != root)
    {
       if (temp.parent.left == temp && temp.parent.right != null)
          return temp.parent.right;

       return mod(temp.parent);
    }

    return null;
}