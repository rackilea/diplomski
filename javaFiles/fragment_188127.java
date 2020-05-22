public static void quicksort(int[] n, int left, int right){
if (left<right){
int pivotindex=Partition(n, left, right);
quicksort(n, left, pivotindex-1);
quicksort(n, pivotindex+1, right);}
}