// in main()
Integer nbrSwaps = new Interger(0);
quickSort(ar, 0, ar.length-1, nbrSwaps);

//quickSort
public static void quickSort(int ar[], int start, int end, Integer swapCount) {

  if(start<end){
    int pIndex = partition(ar, start, end, swapCount);
    quickSort(ar,start, pIndex-1, swapCount);
    quickSort(ar, pIndex+1, end, swapCount);   
  }
}

// partition function
public static int partition(int ar[], int start, int end, Integer swapCount) {
  ... as before ...
}