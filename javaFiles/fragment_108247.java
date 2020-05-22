public class Sorting<E extends Comparable<E>> implements Comparator<E> {

    @Override
    public int compare(final E o1, final E o2) {
        return o1.compareTo(o2);
    }

    public void insertionSort(final E[] data, final Comparator<E> c) {

        final long start = System.nanoTime();
        int compare = 0;
        int numSwaps = 0;

        for (int i = 0; i < data.length; i++) {
            final E tempVal = data[i];
            int j = i;

            while ((j > 0) && (c.compare(data[j - 1], tempVal) > 0)) {
                data[j] = data[j - 1];
                j--;
                compare++;
                numSwaps++;
            }
            data[j] = tempVal;
            numSwaps++;
        }
        final long stop = System.nanoTime();
        final long duration = stop - start;
        System.out.println("Insertion sort with " + data.length + " items took " + duration + " nanoseconds");
    }
}