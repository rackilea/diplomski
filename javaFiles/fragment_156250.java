public static void insertionSort (int[] array) {
      for (int i=1; i < array.length; i++) {
         int aux = array[i];
         int j;
         for (j=i-1; j >= 0 && array[j] > aux; j--){
              array[j+1] = array[j];
          }
         array[j+1] = aux;
      }
   }