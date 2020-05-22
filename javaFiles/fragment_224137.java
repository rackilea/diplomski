public class Queen{

    public static int[] solveQueens(int n){
        int board[] = new int[n];
        placeQueen(board,0);  //it fills the board
        return board;
    }
    private static boolean placeQueen(int[] board, int column){
        int n = board.length;
        int row;
        if (n == column){
            return true;
        }else{
            for (row = 0; row < n; row++){
                int c;
                for (c=0; c<column; c++){
                    if (board[c]==row || c-column==board[c]-row || column-c==board[c]-row){
                        //check if it is safe position (we know 2 queens couldn't place in a same column or row or diameter
                        break;
                    }
                }
                if (c==column){   //if previous loop didn't break...=> it is safe position
                    board[column]=row;
                    if (placeQueen(board, column+1))   //if it is possible to fill the rest of board //else: test the next row
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        int finished[] = solveQueens(8);
        for (int item: finished){
            System.out.print(item);
        }
    }
}