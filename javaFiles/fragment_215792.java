public static void sort( int[][] array ){
     boolean swapped;
     do {
          swapped = false;
          for (int i =0; i<=  array.length  - 2;i++) {
                if (array[i][1] > array[i+1][1]) {
                     //test whether the two elements are in the wrong order
                     int temp = array[i][1];  //1 since CandidateScore is the second one
                     array[i][1] = array[i+1][1];
                     array[i+1][1]=temp;

                     temp = array[i][0]; //interchange the CandidateIds
                     array[i][0] = array[i+1][0];
                     array[i+1][0]=temp;
                     swapped = true;
                }
           }
           if (!swapped) {
              //we can exit the outer loop here if no swaps occurred.
              break;
           }
           swapped = false;
           for (int i =array.length - 2;  i>=0; i--) {
                 if (array[i][1] > array[i+1][1]) {
                      int temp = array[i][1]; 
                      array[i][1] = array[i+1][1];
                      array[i+1][1]=temp;

                      temp = array[i][0]; 
                      array[i][0] = array[i+1][0];
                      array[i+1][0]=temp;
                      swapped = true;
                }
            }
           //if no elements have been swapped, then the list is sorted
     } while (swapped);
}