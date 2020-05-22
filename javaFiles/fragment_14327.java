public class Main {
    public static void main(String[] args) {
        Element<Integer> element = new Element<>(0, 10);
        MiniHeap<Integer> heap = new MiniHeap<>(20);

        heap.insert(element);
    }
}