public class ReverseLevel {
    public static class Node {
        char id;
        Node left;
        Node right;

        public Node(char id) {
            this.id = id;
            left = null;
            right = null;
        }
    }

    static Node            root;
    static Queue<Node>     q;
    static int             index;
    static Stack<Character> stack = new Stack<Character>();

    public static void main(String[] args) {
        createBT();
        printLevelbyLevel(root);

        reverseLevels(root, 0);

        setLevels(root, 0);
        printLevelbyLevel(root);

    }

    private static void printLevelbyLevel(Node root2) {
        q = new LinkedList<Node>();
        q.add(root);
        Queue<Node> nextLevel = new LinkedList<Node>();
        while (!q.isEmpty()) {
            Node n = q.remove();
            printNode(n);
            if (hasLeftChild(n)) {
                nextLevel.add(n.left);
            }
            if (hasRightChild(n)) {
                nextLevel.add(n.right);
            }
            if (q.isEmpty()) {
                System.out.println();
                while (!nextLevel.isEmpty()) {
                    q.add(nextLevel.poll());
                }
            }
        }
    }

    private static void reverseLevels(Node root, int level) {
        if (root == null) {
            return;
        }
        reverseLevels(root.left, level + 1);
        if (level % 2 == 1) {
            stack.push(root.id);
        }
        reverseLevels(root.right, level + 1);

    }

    private static void setLevels(Node root, int level) {
        if (root == null) {
            return;
        }
        setLevels(root.left, level + 1);
        if (level % 2 == 1) {
            root.id = stack.pop();
        }
        setLevels(root.right, level + 1);
    }

    private static boolean hasRightChild(Node n) {
        if (n.right != null)
            return true;
        return false;
    }

    private static boolean hasLeftChild(Node n) {
        if (n.left != null)
            return true;
        return false;
    }

    private static void printNode(Node n) {
        System.out.print(n.id + " ");
    }

    private static void createBT() {
        Node n1 = new Node('a');
        Node n2 = new Node('b');
        Node n3 = new Node('c');
        Node n4 = new Node('d');
        Node n5 = new Node('e');
        Node n6 = new Node('f');
        Node n7 = new Node('g');
        Node n8 = new Node('h');
        Node n9 = new Node('i');
        Node n10 = new Node('g');
        Node n11 = new Node('k');
        Node n12 = new Node('l');
        Node n13 = new Node('m');
        Node n14 = new Node('n');
        Node n15 = new Node('o');
        root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n3.left = n6;
        n3.right = n7;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;
    }
}