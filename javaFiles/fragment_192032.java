private static void quickSort(int[] arr, int lo, int hi){
  if(lo >= hi) return;

  int p = partition(arr, lo, hi);

  // modified to choose small partition first

  if((p - lo )<=(hi-p)){
    System.out.println(String.format("Sorting left first %d %d %d",lo,p,hi)) ;
    quickSort(arr, lo, p);
    quickSort(arr, p+1, hi);
  }else {
    System.out.println(String.format("Sorting right first %d %d %d",lo,p,hi)) ;
    quickSort(arr, p+1, hi);
    quickSort(arr, lo, p);
  }
}