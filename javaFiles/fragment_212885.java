public class LinkedList {
    private Node root;

    public void removeEvens() {
        if (root == null) return;

        // removing all even nodes after the root
        Node prev = root;
        while (prev.next != null) {
            if (isEven(prev.next))
                prev.next = prev.next.next;   // next is even: delete it
            else
                prev = prev.next;             // next is not even: proceed
        }

        // delete root if it's even
        if (isEven(root))
            root = root.next;
    }

    private boolean isEven(Node node) {
        return node.value % 2 == 0;
    }
}