public class Robot3 {

static int nCurrRow = 1;
static int nCurrCol = 1;
static long R = 0;
static BitSet[] cell;

public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int i = 0;

    int n = in.nextInt();
    int k = in.nextInt();

    // Add a border around the matrix with values of 1
    int N = n + 2;
    cell = new BitSet[N];
    for (i = 0; i < cell.length; i++)
        cell[i] = new BitSet(N);

    for (i = 0; i < cell.length; i++) {
        set(cell, 0, i);
        set(cell, i, 0);
        set(cell, i, N-1);
        set(cell, N-1, i);
    }
    set(cell, nCurrRow, nCurrCol);

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
        if (!isSet(cell,nCurrRow + yDir, nCurrCol + xDir)) {
            nCurrRow += yDir;
            nCurrCol += xDir;
            set(cell, nCurrRow, nCurrCol);
            R--;
        } else
            canMove = false;
    }
}

static boolean isSet(BitSet[] cell, int x, int y) {
    return cell[x].get(y);
}
static void set(BitSet[] cell, int x, int y) {
    cell[x].set(y);
}

}