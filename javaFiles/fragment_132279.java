public static boolean subArraySame(int[][] arr) {
    for(int i = 0; i<arr.length; i++) {
        for(int j = 0; j < arr[i].length-1; j++) {
            if(arr[i][j] != arr[i][j+1]) {
                return false;
            }
        }
    }
    return true;
}