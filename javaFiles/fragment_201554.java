public class BinarySearchTree implements Iterable<String> {

    private BinaryTreeNode root = null;
    private int elements;

    @Override
    public Iterator<String> iterator() {
        return new BinarySearchTreeIterator(root);
    }

    private static class BinarySearchTreeIterator implements Iterator<String> {

        private BinaryTreeNode node;

        public BinarySearchTreeIterator(BinaryTreeNode node) {
            if (node != null) {
                this.node = smallest(node);
            } else {
                this.node = node;
            }
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        private static BinaryTreeNode smallest(BinaryTreeNode n) {
            if (n.left != null) {
                return smallest(n.left);
            } else {
                return n;
            }
        }

        @Override
        public String next() {
            String result = node.key;
            if (node.right != null) {
                node = smallest(node.right);
            } else {
                while (node.parent != null && node.parent.left != node) {
                    node = node.parent;
                }
                node = node.parent;
            }
            return result;
        }
    }

    private static class BinaryTreeNode {

        private String key;
        private BinaryTreeNode parent;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(String key) {
            this.key = key;
        }
    }

    public boolean insert(String key) {
        if (key == null) {
            return false;
        }
        int lastElements = elements;
        this.root = insert(key, root, null);
        return lastElements < elements;
    }

    private BinaryTreeNode insert(String key, BinaryTreeNode node, BinaryTreeNode parent) {
        BinaryTreeNode result = node;
        if (node == null) {
            result = new BinaryTreeNode(key);
            result.parent = parent;
            this.elements++;
        } else {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                result.left = insert(key, node.left, node);
            } else if (compare > 0) {
                result.right = insert(key, node.right, node);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        String[] strings = {"l", "f", "t", "c", "g", "p", "u"};
        for (String string : strings) {
            System.out.println("insert: '" + string + "' " + tree.insert(string));
        }
        System.out.println("--");

        for (String s : tree) {
            System.out.println(s);
        }
    }
}