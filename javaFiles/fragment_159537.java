public static void indexOf(int[] arr1, int[] arr2) {

    for(int i = 0; i + (arr1.length - 1) < arr2.length; i++) {
        for(int j = 0; j < arr1.length; j++) {
            if(arr1[j] != arr2[i + j]) {
                break; 
            }
            if(j == (arr1.length - 1)){
                System.out.println(i);
                break; // break to print all the occurrences. return to print only the first.
            }
        }
    }