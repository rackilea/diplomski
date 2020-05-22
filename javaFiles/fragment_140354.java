public class GRID {     
    public int[][] createGrid() {
        int N = StdIn.readInt();
        int thisarray[][] = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int n = (int) (Math.random() * 6 + 1);
                thisarray[x][y] = n;                
            }
        }
        return thisarray;

    }
    public static void main(String []args){     
        GRID g = new GRID();
        int [][] newArray = g.createGrid();
    }
}