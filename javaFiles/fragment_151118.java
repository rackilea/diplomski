public static boolean checkPair(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
       for (int j = i + 1; j < arr.length; j++) {
         if (arr[i] + arr[j] == key) {
           return true;
         }
        //else {      
        //  return false;    <- this returns always false if the 
        //                      first pair isnt a i,j-match
        //}
      } 
    }
    return false;  // stub
}