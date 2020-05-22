public class MinHeap<E extends Comparable<E>> {
    List<E> h = new ArrayList<E>();
    ArrayList<E> arrayPostingsList = new ArrayList<E>();

    // some more code
    public static void main(String[] args) {
        MinHeap<Double> testHeap = new MinHeap<Double>();
        testHeap.add(2.3); // auto-boxing
        System.out.println(testHeap.remove()); //unboxing

    }

    public boolean add(E e) {
        return h.add(e);
    }

    public E remove() {
        E removedNode = h.get(0);
        E lastNode = h.remove(h.size() - 1);

        // this seems to be the problem
        return removedNode;
    }
}