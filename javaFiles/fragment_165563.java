import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node head = null;
    private Node tail = null;

    public static void main(String[] args) {
        MyLinkedList<String> li = new MyLinkedList<>();
        li.add("1");
        li.add("2");
        li.add("3");
        li.add("4");
        li.add("5");

        for (String s : li) {
            System.out.println(s);
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
        } else {
            Node n = new Node(data, tail);
            tail.next = n;
            tail = n;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove() {

            }
        };
    }

    class Node {
        final T data;
        Node prev = null;
        Node next = null;

        Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }
}