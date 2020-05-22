public class GRID {     
    public int[][] createGrid(int N) {
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
        int [][] newArray = g.createGrid(StdIn.readInt());  //new array everytime on the basis of input value.
    }
}