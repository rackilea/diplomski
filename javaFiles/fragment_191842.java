public class AVLTreeNode {
    private int value;
    private AVLTreeNode left;
    private AVLTreeNode right;
    private AVLTreeNode parent;
    //constructor
    //getters/setters
    //required functions
    boolean insert(AVLTreeNode node);
    AVLTreeNode remove(int value);
    AVLTreeNode remove(AVLTreeNode node);
    List<AVLTreeNode> inorderTraversal();
}