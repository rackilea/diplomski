public class <K,V> LRU_Map implements Map<K,V> {
    private class Node {
        private final V value;
        private Node previous = null;
        private Node next = null;

        public Node(V value) {
            this.value = value;
            touch();
            if (tail == null)
                tail = this;
        }

        public V getValue() {
            touch();
            return value;
        }

        private void touch() {
            if (head != this) {
                unlink();
                moveToHead();
            }
        }

        private void unlink() {
            if (tail == this)
                tail = prev;
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
        }

        private void moveToHead() {
            prev = null;
            next = head;
            head = this;
        }

        public void remove() {
            assert this == tail;
            assert this != head;
            assert next == null;
            if (prev != null)
                prev.next = null;
            tail = prev;
        }
    }

    private final Map<K,Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;

    public void put(K key, V value) {
        if (map.size() >= MAX_SIZE) {
            assert tail != null;
            tail.remove();
        }
        map.put(key, new Node(value));
    }

    public V get(K key) {
        if (map.containsKey(key))
            return map.get(key).getValue();
        else
            return null;
    }

    // and so on for other Map methods
}