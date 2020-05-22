class QuickSort<T extends Comparable<T>> {
    public void sort(T[] array) { ... }
}

QuickSort<Integer> intSorter = new QuickSort<>();
int[] array = {5, 8, 2};
intSorter.sort(array);