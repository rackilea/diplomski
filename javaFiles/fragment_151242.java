public class Main {

    //moving in two directions, right and down, is sufficient
    //to cover a whole matrix without visiting the same address twice

    public static void main(String[] args) {
        int delta= 1;
        int [][]matrix =  new int[][]{
                                     {8, 15, 20, 33, 35},
                                     {60, 59, 58, 32, 31},
                                     {59, 17, 57, 56, 55},
                                     {55, 15, 13, 58, 16}};
        System.out.print(" longest Path= "+ longestPath(matrix, delta));
    }

     public static int longestPath (int arr[][] , int delta){
            return longestPath(arr, 0, 0, delta , 0);
     }

     //check all matrix elements, keep longest path found
     public static int longestPath (int arr[][],int row,int col, int num, int max){

        int steps = searchPath(arr,row,col,num, 1); //Initial path length is always 1
        if (steps > max) {  max=steps;  }

        if (row == arr.length-1 && col == arr[row].length -1 )  return max;
        col ++;
        if(col == arr[row].length){//end of row exceeded
            row++;    //new row
            col = 0;  //first column
        }

        return longestPath(arr,row,col,num,max);
    }

    public static int searchPath(int arr[][],int row,int col,int num ,int pathLength){

        int[][] neighbors = getNeighbors(arr, row, col, num);
        int rightPath = 0 , downPath = 0;
        //right neighbor
        if(neighbors[0] != null){
            rightPath = searchPath(arr, neighbors[0][0], neighbors[0][1], num, pathLength+1);
        }

        //down neighbor
        if(neighbors[1] != null){
            downPath = searchPath(arr, neighbors[1][0], neighbors[1][1], num, pathLength+1);
        }

        int returnPath = Math.max(rightPath, downPath); //max return value 
        return Math.max(pathLength, returnPath) ; //max of path length and returned value 
    }

    //return neighbors with value smaller by delta
    //returned array[0] represents right neighbor row, col  or null
    //returned array[1] represents down  neighbor row, col  or null
    private static int[][] getNeighbors(int[][] arr, int row, int col, int delta) {

        //moving in two directions, right and down, is sufficient
        //to cover a whole matrix without visiting the same address twice

        int[][] neighbors = {null, null};
        //right neighbor
        int newCol = col +1;
        if(isValidAddress(row, newCol, arr.length, arr[0].length)){
            if(arr[row][col] - arr[row][newCol] == delta){
                neighbors[0] = new int[]{row, newCol};
            }
        }

        //down neighbor
        int newRow = row + 1 ;
        if(isValidAddress(newRow, col, arr.length, arr[0].length)){
            if(arr[row][col] - arr[newRow][col] == delta){
                neighbors[1] = new int[]{newRow, col};
            }
        }

        return neighbors;
    }

    private static boolean isValidAddress(int row, int col, int maxRow, int maxCol) {
        if(row < 0 || col < 0) return false;
        if(row >= maxRow || col >= maxCol) return false;
        return true;
    }
}