public class BST<E extends Comparable<E>> {

    public static <E> boolean equalTrees(Node<E> r1, Node<E> r2) {
        return false;
    }

    public static class Node<E> {
        private E value;
        private Node<E> left, right, parent;
    }

}