private static void tighten(IntTreeNode root){
    if (root == null)
        return;

    //Recurse on both children - if either are null, returns immediately
    tighten(root.left);
    tighten(root.right);

    //Try to tighten each child. If it shouldn't be tightened, the exception is thrown.
    //Could be done using if logic, this way is fairly concise 
    //and leaves both of the helper methods for use elsewhere
    try{
        IntTreeNode n = onlyChild(root.left);
        root.left = n;   
    }catch(IllegalArgumentException ioe){}
    try{
        IntTreeNode n = onlyChild(root.right);
        root.right = n;   
    }catch(IllegalArgumentException ioe){}
}

/** Returns the number of direct children of node, or 0 if node == null */
private static int countDirectChildren(IntTreeNode node){
    if (node == null)
        return 0;
    int i = 0;
    if (node.left != null) i++;
    if (node.right != null) i++;
    return i;
}

/** Returns the single child of node. 
 *  Throws an IllegalArgumentException if node has a number of 
 *  children other than 1, or if node is null */
private static IntTreeNode onlyChild(IntTreeNode node) throws IllegalArgumentException{
    if (countDirectChildren(node) != 1) 
        throw new IllegalArgumentException(node + " doesn't have exactly one child");
    if (node.right != null) return node.right;
    else return node.left;
}