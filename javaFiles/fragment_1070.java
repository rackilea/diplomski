public static void main(String[] args){
    int i = 5;
    Integer[] arr = {1,3,4,5,2};
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();

    maxHeap.heapSort(arr, i);
}