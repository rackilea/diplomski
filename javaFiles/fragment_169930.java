public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * Default constructor
     *
     * @param head
     */
    public LinkedList() {
        super();
        this.head = null;
    }

    /**
     * Inserts a new node at the beginning of this list.
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data, head);
        head = newNode;
    }

    public void add(T data) {

        if ( head == null )
        {
            head = new Node<T>(data, null);
            return;
        }

        Node<T> tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = new Node<T>(data, null);
    }

    /**
     * @param head
     * @return
     */
    public T getNode() {
        return head.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    public class ListIterator<T> implements Iterator<T> {
        private Node<T> currentNode;
        private Node<T> previous;

        /**
         * @param currentNode
         */
        public ListIterator() {
            super();
            this.currentNode = (Node<T>) head;
            this.previous = null;
        }

        @Override
        public boolean hasNext() {
            if (currentNode != null && currentNode.next != null)
                return true;
            else
                return false;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            if ( previous == null )
            {
                previous = currentNode;
                return previous.data;
            }
            T node = currentNode.data;
            currentNode = currentNode.next;
            return currentNode.data;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
        }
    }

    // Same as using struct in C
    private static class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * @param data
         * @param next
         */
        public Node(T data, Node<T> next) {
            super();
            this.data = data;
            this.next = next;
        }

        /**
         * @param next
         */
        public Node(Node<T> next) {
            super();
            this.data = null;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("aaaa");
        list.add("bbbb");
        list.addFirst("cccc");
        list.add("dddd");
        list.add("eeee");
        list.add("ffff");
        for ( String s : list ) // same thing as using an iterator
            System.out.println(s);
    }
}