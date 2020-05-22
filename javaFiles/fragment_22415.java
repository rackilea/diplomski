public class Domino {
    final int N;
    final int M;
    final char[][] board;
    int count;

    static final char EMPTY = 0;

    Domino(int M, int N) {
        this.M = M;
        this.N = N;
        board = new char[M][N]; // all EMPTY
        this.count = 0;
        generate(0, 0);
        System.out.println(count);
    }

    void printBoard() {
        String result = "";
        for (char[] row : board) {
            result += new String(row) + "\n";
        }
        System.out.println(result);     
    }

    void generate(int r, int c) {
       //... see next code block
    }
    public static void main(String[] args) {
        new Domino(6, 6);
    }
}