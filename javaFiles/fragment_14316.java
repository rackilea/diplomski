public class MergeandSort {

    public static void main(String[] args) {
        int[] set1 = {1,2,6,9,18};
        int[] set2 = {2,3,7,10,21,30};
        int[] sorted = new int[k];

        int smallest = set1[0];
        int smallests = set2[0];

        int i = 0, j = 0, c = 0;
        while(i < set1.length && j < set2.length && c < k){
            if (set1[i] < set2[j])
                sorted[c++] = arr1[i++];
            else
                sorted[c++] = arr2[j++];

        while (i < set1.length && c < k)
            sorted[c++] = arr1[i++];
        while (j < set2.length && c < k)
            sorted[c++] = arr2[j++];

        System.out.println(sorted);
    }
}