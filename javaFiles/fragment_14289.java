public static int FindNum(int[] intArray, int intArgs) {
   for (int index = 0; index < intArray.length; index++){
        if (intArray[index] == (intArgs)){
            System.out.println("Found It! = " + index);
            return index;
        }
   }
   throw new NoSuchElementException("Element not found in array.");
}