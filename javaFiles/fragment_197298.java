public class MergeSort {

public static void main(String[] args) {
    int[] a1 = { 1, 5, 6 };
    int[] a2 = { 2, 4, 6, 9, 11 };
    int[] a3 = merge(a1,a2);
    for (int i = 0; i<a3.length; i++)
        System.out.printf("%d ", a3[i]);
    System.out.println();

}
public static int[] merge(int[] list1, int[] list2) {
    int[] merge = new int[list1.length + list2.length];
    int i = 0; // Array index for list1
    int j = 0; // Array index for list2
    for (int k = 0; k < merge.length; k++) {
        int v1 = (i < list1.length) ? list1[i] : Integer.MAX_VALUE;
        int v2 = (j < list2.length) ? list2[j] : Integer.MAX_VALUE;
        if (v1 < v2) {
            merge[k] = v1;
            i++;
        } else {
            merge[k] = v2;
            j++;
        }
    }
    return merge;
}

}