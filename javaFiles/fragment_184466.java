/*
 * Method Used to get Values for one Subtree
 * Returns a TreeValues Object containing that (sub-)trees values
 */ 
public TreeValues GetSubTreeValues(BNode node)
{
    //Keep information on the data of the Subtree's Startnode
    //We gonna need it later
    BNode SubtreeRoot = node;

    //The Min value of a BST Tree exists in the leftmost child
    //and the Max in the RightMost child

    int MinValue = 0;

    //If there is not a Left Child
    if(node.left == null)
    {
        //The Min Value is this node's data
        MinValue = node.data;
    }else
    {
        //Get me the Leftmost Child
        while(node.left != null)
        {
            node = node.left;
        }
        MinValue = node.data;
    }
    //Reset the node to original value
    node = SubtreeRoot; //Edit - fix
    //Similarly for the Right Child.
    if(node.right == null)
    {
        MaxValue = node.data;
    }else
    {
        int MaxValue = 0;
        //Similarly
        while(node.right != null)
        {
            node = node.right;
        }
        MaxValue = node.data;
    }
    //Return the info.
    return new TreeValues(SubtreeRoot , MinValue , MaxValue);   
}