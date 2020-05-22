public static void reverseRows(int[][] inTwoDArray){
    int lastIndex = inTwoDArray.length-1;
    for (int row = 0; row < inTwoDArray.length/2; row++){
        int[] temp = inTwoDArray[row];
        inTwoDArray[row] = inTwoDArray[lastIndex - row];
        inTwoDArray[lastIndex - row] = temp;
    }
    printArray(inTwoDArray);
}