class FindDuplicate {
    static int STRING_LENGTH = 3;

    void printRepeating(int arr[], int size) {
        int i; 
        System.out.println("The repeating elements are : ");
        String strVal = "";
        for (int ii = 0; ii < size; ii++) {
            strVal += arr[ii]; 
        }
        // strVal now has something we can search with.

        for (i = 0; i < size; i++) {
            int end = Math.min(size,i+STRING_LENGTH );
            String searchString = strVal.substring(i, end);
            if (searchString.length() != STRING_LENGTH)
                break;  // at end of arr, doesn't have length to search 
            int matchIndex = strVal.indexOf(searchString, i+1);
            if (matchIndex != -1) {
               String match = strVal.substring(matchIndex, matchIndex + STRING_LENGTH);
               System.out.print(match + " ");
               break; // done with loop
            }
        }        
    } 


    public static void main(String[] args) {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1, 2, 3, 1, 2, 3, 1, 2, 3 };
        int arr_size = arr.length;
        duplicate.printRepeating(arr, arr_size);
    }
}