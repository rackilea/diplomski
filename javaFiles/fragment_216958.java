public class TreeCompare {
    public static void main(String[] args) {
        Tree<Integer> treeA = new Tree<Integer>();
        Tree<Integer> treeB = new Tree<Integer>();

        Node<Integer> treeArootNode = new Node<Integer>(0);
        Node<Integer> treeBrootNode = new Node<Integer>(0);

        Node<Integer> treeAnode1 = new Node<Integer>(1);
        Node<Integer> treeAnode2 = new Node<Integer>(2);
        Node<Integer> treeAnode3 = new Node<Integer>(3);

        Node<Integer> treeBnode1 = new Node<Integer>(1);
        Node<Integer> treeBnode2 = new Node<Integer>(2);
        Node<Integer> treeBnode3 = new Node<Integer>(3);

        treeA.root = treeArootNode;
        treeB.root = treeBrootNode;

        treeA.root.left = treeAnode1;
        treeA.root.right = treeAnode2;

        treeB.root.left = treeBnode2;
        treeB.root.right = treeBnode1;

        treeAnode2.left = treeAnode3;
        treeBnode2.right = treeBnode3; // or treeBnode2.left

        System.out.println(treeA);
        System.out.println(treeB);

        System.out.println(treeA.equals(treeB));
    }
}