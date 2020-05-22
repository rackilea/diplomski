public class CreateBoard {

public static Card[][] createBoard() {
    Card[][] board = new Card[4][4];

    for(int i = 1; i <= 8; i++) {
        for(int j = 1; j <= 2; j++) {

            boolean boardLocation = false;

            while(!boardLocation) {
                int row = (int)(Math.random() * 4); 
                int column = (int)(Math.random() * 4);

                if(board[row][column] == null) {
                    boardLocation = true;
                    board[row][column] = new Card(i);
                    }
                }
            }
        }
                return board;
    }
}