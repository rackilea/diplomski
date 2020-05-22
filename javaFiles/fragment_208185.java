public class test
{
    private String[][] board = new String[3][3];
    private String turn = "X";

    public test() {

    }

    public void move(int x, int y) {   
        board[x][y] = turn;

        if (turn.equals("X")) {
            turn = "O";
        }else {
            turn = "X";
        }
    }

    public void display() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}