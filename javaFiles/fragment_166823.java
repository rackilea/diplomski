private static void friendArrayRecursive(int[][] arr, int row, int col){
    if(row < arr.length){
        if (col < row) {
            int temp = arr[row][col];
            arr[row][col] = arr[col][row];
            arr[col][row] = temp;
            friendArrayRecursive(arr, row, col + 1);
        } else {
            friendArrayRecursive(arr, row + 1, 0);    
        }
    }
}