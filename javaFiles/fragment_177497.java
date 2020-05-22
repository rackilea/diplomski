public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int     counter;

    public LinkedList() {
    }

    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.insertFirst("p");
        list.insertFirst("a");
        list.insertFirst("e");
        list.insertFirst("h");

        list.insertAt(2, "A");
        for (Node n = list.first; n != null; n = n.next) {
            System.out.println(n.data);
        }
    }

    private void insertFirst(T s) {
        insertAt(0, s);
    }

    public LinkedList<T> insertAt(int index, T elem) {
        if (index > counter) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<T>(null, elem, null);
        if (counter == 0) {
            first = last = node;
        } else {
            if (index == 0) {
                node.next = first;
                first.prev = node;
                first = node;
            } else if (index == counter) {
                node.prev = last;
                last.next = node;
                last = node;
            } else {
                Node<T> current = this.first;

                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                node.next = current;
                node.prev = current.prev;
                current.prev.next = node;
                current.prev = node;
            }
        }
        counter++;
        return this;
    }
}

class Node<T> {

    public T       data;
    public Node<T> next;
    public Node<T> prev;

    public Node(Node<T> prev, T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node() {

    }
}