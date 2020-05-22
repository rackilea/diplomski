public class LinkedBag<T> {

    private Node first;

    private int n;

    public LinkedBag() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public int search(T item) {
        if(item == null) {
            throw new IllegalArgumentException("Cannot search null");
        }
        Node x = first;
        int c = size() - 1;
        while(x != null) {
            if(x.item.equals(item)) {
                return c;
            }
            x = x.next;
            c--;
        }
        return -1;
    }

    private class Node {
        private T item;

        private Node next;
    }

    public static void main(String[] args) {
        LinkedBag<Integer> intBag = new LinkedBag<>();
        intBag.add(1);
        intBag.add(2);
        intBag.add(3);
        System.out.println(intBag.search(1) == 0);
        System.out.println(intBag.search(2) == 1);
        System.out.println(intBag.search(3) == 2);
        System.out.println(intBag.search(4) == -1);
    }
}