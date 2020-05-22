public class HashTable<K, V> {
    private Node<?>[] generics;

    static class Node<V> {
        V value;
        Node next;
        public Node(V val) {
            value = val;
        }
    }
    public HashTable(int size) {
        generics = new Node<?>[size];
    }
 }