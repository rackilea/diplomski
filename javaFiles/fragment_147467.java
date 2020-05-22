public void deleteNode(TreeNode removeNode, TreeNode root)
{
    TreeNode parent = removeNode.getParent();   //Find parent node to removeNode.

    if(removeNode.Left==null && removeNode.Right==null) //0 children
    {
        if(parent.Left.equals(removeNode))
             parent.Left = null;                //Set the parents reference to null. 
        else
             parent.Right = null;
    }
    else if(removeNode.Left==null)//1 child
    {
        if(parent.Left.equals(removeNode))
             parent.Left = removeNode.Right;  //Reassign the parents reference to the correct node. 
        else
             parent.Right = removeNode.Right;
    }
    ... //etc.