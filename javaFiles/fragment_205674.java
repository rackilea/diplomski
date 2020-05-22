public class Robot2 {

static int nCurrRow = 1;
static int nCurrCol = 1;
static long R = 0;
static int[][] cell;

public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int i = 0;

    int n = in.nextInt();
    int k = in.nextInt();

    // Add a border around the matrix with values of 1
    int N = n + 2;
    cell = new int[N][N];
    for (i = 0; i < cell.length; i++) {
        cell[0][i] = 1; // Top border
        cell[i][0] = 1; // Left border
        cell[i][N - 1] = 1; // Right border
        cell[N - 1][i] = 1; // Bottom border
    }
    cell[nCurrRow][nCurrCol] = 1;
    R = (long)n * n - 1; // Number of remaining unvisited cells

    int sec1 = in.nextInt();
    int sec2 = 0;
    String dir1 = in.next();
    String dir2;

    for (i = 0; i < k - 1; i++) {

        sec2 = in.nextInt();
        dir2 = in.next();
        move(sec2-sec1, dir1);
        dir1 = dir2;
        sec1 = sec2;

    }
    move(n, dir1);

    System.out.println(R);

    in.close();

}

static void move(int t, String dir1) {
    boolean canMove = true;
    int xDir = 0;
    int yDir = 0;
    if (dir1.equals("SE")) {
        xDir = 1;
        yDir = 1;
    } else if (dir1.equals("NE")) {
        xDir = 1;
        yDir = -1;
    } else if (dir1.equals("E")) {
        xDir = 1;
    } else if (dir1.equals("N")) {
        yDir = -1;
    } else if (dir1.equals("NW")) {
        xDir = -1;
        yDir = -1;
    } else if (dir1.equals("W")) {
        xDir = -1;
    } else if (dir1.equals("SW")) {
        xDir = -1;
        yDir = 1;
    } else if (dir1.equals("S")) {
        yDir = 1;
    }
    for (int j = 0; j < t && canMove; j++) {
        if (cell[nCurrRow + yDir][nCurrCol + xDir] == 0) {
            nCurrRow += yDir;
            nCurrCol += xDir;
            cell[nCurrRow][nCurrCol] = 1;
            R--;
        } else
            canMove = false;
    }
}
}