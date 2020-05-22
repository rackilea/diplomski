public static boolean array2dEquals(int[][] firstArray, int[][] secondArray){
    if(firstArray.length != secondArray.length) return false;
    for (int row = 0; row < firstArray.length; row++) {
        if(firstArray[row].length != secondArray[row].length) return false;
        for (int column = 0; column < firstArray[row].length; column++) {
            if(firstArray[row][column] != secondArray[row][column]) return false;
        }   
    } 
    return true;
}