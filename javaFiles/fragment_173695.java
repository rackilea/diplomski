public class HashTable<K, V> {
    private Node<V>[] generics;

    static class Node<V> {
        V value;
        Node next;
        public Node(V val) {
            value = val;
        }
    }
    private HashTable(int size) {
        generics = (Node<V>[]) new Node[size];
    }
}