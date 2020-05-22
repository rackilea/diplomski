// Precondition: array[left..lHigh] is sorted and array[right...rHigh] is sorted.
  // Postcondition: array[left..rHigh] contains the same elements of the above parts, sorted.
  public static void mergeSort(int[] array, int left,  int lHigh, int right, int rHigh) {   
        // temp[] needs to be as large as the number of elements you're sorting (not half!)
        //int elements = (rHigh - lHigh +1) ;
        int elements = rHigh - left;

        int[] temp = new int[elements];

        // this is your index into the temp array
        int num = left;

        // now you need to create indices into your two lists
        int iL = left;
        int iR = right;

        // Pseudo code... when you code this, make use of iR, iL, and num!
        while( temp is not full ) {
           if( left side is all used up ) {
             copy rest of right side in.
             make sure that at the end of this temp is full so the
               while loop quits.
           }
           else if ( right side is all used up) {
             copy rest of left side in.
             make sure that at the end of this temp is full so the
               while loop quits.
           }
           else if (array[iL] < array[iR]) { ... }
           else if (array[iL] >= array[iR]) { ... }
        }
 }