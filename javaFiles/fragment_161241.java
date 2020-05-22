public class TreeNodeDemo {

    List<Integer> values = new ArrayList<Integer>();

    public List<Integer> storeKeyValues(TreeNode root) {
        treeTravel(root);
        return values;
    }

    private void treeTravel(TreeNode node) {
        if (node != null) {
            treeTravel(node.left);
            values.add(node.value);
            treeTravel(node.right);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        System.out.println(new TreeNodeDemo().storeKeyValues(root));
    }

}