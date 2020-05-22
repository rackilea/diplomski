static void recursivelyInsertElement(int[] array, int start, int elem) {
    if (start == array.length) {
        return;
    }

    if (array[start] > elem) {
        System.out.print(elem + " ");
        printArrayAfterIndex(array,start);
    }

    System.out.print(array[start] + " ");
    recursivelyInsertElement(array, start + 1, elem);
}