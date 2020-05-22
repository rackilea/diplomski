static List<TreeNode> l = new LinkedList<TreeNode>();

    public static Iterator<TreeNode> inorderItr(TreeNode root) {
    recursionInorder(root);
    Iterator<TreeNode> itr = l.iterator();

     return itr;

    }

    public static void recursionInorder(TreeNode node){
        if(node==null)
              return;

        recursionInorder(node.left);
        l.add(node);
        recursionInorder(node.right);
    }