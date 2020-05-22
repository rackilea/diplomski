public static int find(int[] arr, int thingToFind){
  int i;
  for(i = 0; i < arr.length(); i++){
    if(arr[i] == thingToFind){
      return i;
    }
  }
  return -1;
}