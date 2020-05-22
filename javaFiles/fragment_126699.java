class Tree {

    private TreeNode root;

    // ...

    public List<TreeNode> postOrder() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();  
        fillList(root, nodes);
        return nodes;
    }

    private void fillList(TreeNode node, List<TreeNode> nodeList) { // private!
        if(node != null) {
            fillList(node.left, nodeList);
            fillList(node.right, nodeList);
            nodeList.add(node);
        }
    }
}