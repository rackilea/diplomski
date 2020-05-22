public void GetTreeValues(BNode node)
{
    //Add this node to the Container with Tree Data 
    myValues.add(GetSubTreeValues(node));

    //Get Left Child Values, if it exists ...
    if(node.left != null)
        GetTreeValues(node.left);
    //Similarly.
    if(node.right != null)
        GetTreeValues(node.right);
    //Nothing is returned, we put everything to the myValues container
    return; 
}