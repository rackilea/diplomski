public class MaxHeapTest<E extends Comparable<E>> {
    List<E> heapArray = new ArrayList<>();

    public static void main(String... args) {
        int N = 13;
        MaxHeapTest<Integer> maxHeap = new MaxHeapTest();
        for (int i = 0; i < N; ++i) { // ascending;
            maxHeap.insert(i);
        }

        while (!maxHeap.isEmpty()) { // descending now;
            System.out.print(maxHeap.delMax() + " ");
        }
    }

    public E delMax() {
        E e = heapArray.get(0);
        swap(0, heapArray.size() - 1);
        heapArray.remove(heapArray.size() - 1);
        sinkDown(0);
        return e;
    }

    public void insert(E item) {
        heapArray.add(item);
        bubbleUp(item);
    }

    public boolean isEmpty() {
        return heapArray.isEmpty();
    }

    private void bubbleUp(E x) {
        int k = heapArray.indexOf(x);
        int j = (k - 1) / 2;
        while (j >= 0) {
            if (heapArray.get(j).compareTo(heapArray.get(k)) < 0) {
                swap(k, j);
                k = j;
                j = (j - 1) / 2;
            } else break;
        }
    }

    private void sinkDown(int k) {
        int j = 2 * k + 1;
        while (j < heapArray.size()) {
            if (j < heapArray.size() - 1 && heapArray.get(j).compareTo(heapArray.get(j + 1)) < 0) j++;
            if (heapArray.get(k).compareTo(heapArray.get(j)) < 0) {
                swap(k, j);
                k = j;
                j = 2 * j + 1;
            } else break;
        }
    }

    private void swap(int i, int j) {
        E temp = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, temp);
    }
}