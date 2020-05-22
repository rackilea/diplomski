Comparable[] a = new Comparable[]{15, 9, 12, 19, 49, 43, 57, 70, 78, 87};
Comparable[] b = new Comparable[a.length];
MergeSort.MergeSort(a, b, 0, a.length - 1);

for (int i = 0; i <= a.length - 1; i++) {
    System.out.print(a[i]);
    if (i < a.length - 1)
        System.out.print(", ");
    else {
        System.out.print("}\n\n");
    }
}