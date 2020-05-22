// LinkedList class
public class LinkedList<T, E extends Comparable<T>> implements List<T, E> {
    private E item;
    private LinkedList<T, E> next;

    // Constructor
    public LinkedList() {
        item = null;
        next = null;
    }

    public static void main(String[] args) {
        // Example statement, where T = Long.class and E = String.class
        LinkedList<Long, Termin<String>> k = new LinkedList<Long, Termin<String>>();
    }
}