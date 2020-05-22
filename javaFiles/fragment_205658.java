import java.util.Objects;

class LinkedList<T> {

    private class Node<E> {
        Node<E> next; 
        E val;

        Node(E val) {
            this.val = val;
        }
    }

    private Node<T> head;

    void add(T val) {
        Node<T> node = new Node<>(val);

        if (head == null) {
            head = node;
        } else {
            Node<T> p = head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = node;
        }
    }

    void show() {
        if (head == null)
            return;

        Node<T> p = Objects.requireNonNull(head);

        while (p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println(p.val);
    }
}

class Main {

    public static void main(String... args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(22);
        ll.add(2);
        ll.add(4);
        ll.add(32);
        ll.add(3);
        ll.add(1);
        ll.add(44);

        ll.show();

    }
}