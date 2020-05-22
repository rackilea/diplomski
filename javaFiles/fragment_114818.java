public static int getMax(int [][] grid,int row,int col){
    if (isTopRight(grid,row,col)) {
       return grid[row][col];
    } else if (!isValid(grid,row,col)){
        return Integer.MIN_VALUE;
    } else {
        return grid[row][col] + Math.max(getMax(grid,row-1,col),getMax(grid,row,col+1));
    }
}