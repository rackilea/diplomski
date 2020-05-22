public static String[] fitlerNullString(final String[] array) {

       // Return the original array if null or empty
       if(array == null || array.length == 0) {
           return array;
       }

       // Create a new array with the size of the passed array
       String[] strings = new String[array.length];
       // For keeping track of indices of the new array
       int ctr = 0;

       for(int i = 0; i < array.length; i++) {

           // If null or empty continue to the next item if any
           if(array[i] == null || array[i].isEmpty()) {
               continue;
           }

           // Otherwise add and increase the counter
           strings[ctr] = array[i];
           ctr ++;

       }

       // return the array
       return Arrays.copyOfRange(strings, 0, ctr);

   }