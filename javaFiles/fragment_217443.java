public static int[] reOrder(int[] arr) {
    int temp;
    for(int i = 0, j = 0; i < arr.length; i++) {
        if(arr[i] == 3 && i != arr.length - 1 && arr[i+1] != 4) { // we need to do it only if successor isn't 4, and position isn't last
            while (j < arr.length && arr[j] != 4 || (j > 0 && arr[j-1] == 3)) { //searching for first unused '4' in array
                j++;
            }
            if (arr[j] == 4) {
                temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    return arr;
}