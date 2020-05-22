find(int[] arr) {
    if(arr.length > 0) {
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-1 != arr[i-1]){
                System.out.println("The element " + arr[i] + " at the index " + i + " is the first not consecutive element of the array";
                return arr[i];
            }
        }
    }
    return null; //If we reach the end of the loop, there is no number not consecutive to a previous one.
}