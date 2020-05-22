public static int[][] fill(int[][] map, int i, int j, int color) {

    int origColor = map[i][j];
    fill(map, i, j, color, origColor);


    return map;

    }

private static void fill(int[][] map, int i, int j,int color, int   origColor) {



    //checks if index is inside matrix and if the index is equal to original   number.

    if ((i<map.length)&&(i>=0)&&(j<map.length)&&(j>=0)&&(origColor==map[i][j]))

    {

    map[i][j]=color;



    //recursive call for north east west south.

    fill(map,i-1,j,color,origColor);

    fill(map,i+1,j,color,origColor);

    fill(map,i,j-1,color,origColor);

    fill(map,i,j+1,color,origColor);
    }


    }
 public static void printBoard(int[][] board) {
if (board == null)
    System.out.println("null");
else for (int i=0; i<board.length; i++) {
    if (board[i] == null)
        System.out.println("null");
    else
        for (int j=0; j<board[i].length; j++) 
            System.out.print(board[i][j]);
    System.out.println();
}
}