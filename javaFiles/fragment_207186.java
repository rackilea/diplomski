public static void selectionSort(int[] arrayToSort){
    int smallest;
    for(int i = 0; i < arrayToSort.length; i++){
        smallest = i;
        for(int j = i+1; j < arrayToSort.length; j++){
            if(arrayToSort[j] < arrayToSort[smallest]){
                smallest = j;
            }
        }
        if(smallest != i){
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[smallest];
            arrayToSort[smallest] = temp;
        }
    }
}