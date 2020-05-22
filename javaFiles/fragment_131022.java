public static void insertionSort(int[] A){
    for(int j = 1; j < A.length; j++){
        int key = A[j];
        int i = j; //change - don't -1
        while(i > 0 && A[i-1] > key){ //change here, must go from 0 and note change to index
            A[i] = A[i - 1]; //change here
            i = i - 1;
        }
        A[i] = key; //change here
    }
}