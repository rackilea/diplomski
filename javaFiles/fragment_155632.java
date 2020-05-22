for ( int i = 0, j = pivot - 1; i < j; i++ ) {

   if ( anArray[i] > pivotValue ) {
      //i now represents the earliest index that is greater than the pivotValue,
      //so find the latest index that is less than the pivotValue
      while ( anArray[j] > pivotValue ) {
         //if j reaches i then that means that *all* 
         //indexes before i/j are less than pivot and all after are greater
         //and so we should break out here
         j--;
      }

      swap(anArray, i, j);
   }
} 

//swap pivot into correct position
swap(anArray, pivot, j+1);