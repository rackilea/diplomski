public static void insertInOrder(int element, int[] a, int first, int last) {
    if (element >= a[last])
        a[last + 1] = element;
    else if (first < last) {
        a[last + 1] = a[last];
        insertInOrder(element, a, first, last - 1);
    } 
    else // first == last and element < a[last]
    {
        a[last + 1] = a[last];
        a[last] = element;
    }
}

public static void insertion_sort_recur(int[] arr, int first, int last) {
    if (first < last) {
        insertion_sort_recur(arr, first, last - 1); // avoids looping thru arr[0..last-1]
        insertInOrder(arr[last], arr, first, last - 1); // considers arr[last] as the first element in the unsorted list
    }
}

public static void main(String args[]) {
    int A[] = { 5, 3, 2, 4, 6, 1 };
    insertion_sort_recur(A, 0, 5);
    for(int i=0; i < A.length; i++) {
        System.out.println(A[i]);
    }
}