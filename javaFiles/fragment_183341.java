public class ArrayHeap<E> implements PriQue<E> {
    private static class Entry<E> {
        int pri;
        E data;

        // ...

        public E getData() {
            return data;
        }
    }

    Entry<E>[] heap;
    int cnt;

    public ArrayHeap(int size) {
        heap = (Entry<E>[])new Entry<?>[size];
        // or: heap = new Entry[size];
        cnt = 0;
    }

    public E remove() {
        E tmp = heap[--cnt].getData();
        return tmp;
    }

    // ...
}