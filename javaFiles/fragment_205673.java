public class Robot {

public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int j = 0;
    int i = 0;

    int n = in.nextInt();
    int k = in.nextInt();

    int[] arrTime = new int[k + 1];
    String[] arrDirection = new String[k];
    for (j = 0; j < k; j++) {

        int seconds = in.nextInt();
        if (seconds >= 0 && seconds <= 1000000) {
            arrTime[j] = seconds;
        }

        String direction = in.next();
        arrDirection[j] = direction;
    }
    if (k >= 2 && k < 1000000) {
        arrTime[k] = arrTime[k - 1] + n;
    }

    int N = n + 2;
    BitSet[] cell = new BitSet[N];
    for (j = 0; j < cell.length; j++)
        cell[j] = new BitSet(N);

    for (j = 0; j < cell.length; j++) {
        set(cell, 0, j);
        set(cell, j, 0);
        set(cell, j, N-1);
        set(cell, N-1, j);
    }
    int nCurrRow = 1;
    int nCurrCol = 1;
    set(cell,nCurrRow,nCurrCol);
    long R = n * n - 1;

    for (i = 0; i < arrTime.length - 1; i++) {
        boolean canMove = true;
        int xDir = 0;
        int yDir = 0;
        if (arrDirection[i].equals("SE")) {
            xDir = 1;
            yDir = 1;
        } else if (arrDirection[i].equals("NE")) {
            xDir = 1;
            yDir = -1;
        } else if (arrDirection[i].equals("E")) {
            xDir = 1;
        } else if (arrDirection[i].equals("N")) {
            yDir = -1;
        } else if (arrDirection[i].equals("NW")) {
            xDir = -1;
            yDir = -1;
        } else if (arrDirection[i].equals("W")) {
            xDir = -1;
        } else if (arrDirection[i].equals("SW")) {
            xDir = -1;
            yDir = 1;
        } else if (arrDirection[i].equals("S")) {
            yDir = 1;
        }
        for (j = arrTime[i]; j < arrTime[i + 1] && canMove; j++) {
            if (!isSet(cell,nCurrRow + yDir, nCurrCol + xDir)) {
                nCurrRow += yDir;
                nCurrCol += xDir;
                set(cell,nCurrRow,nCurrCol);
                R--;
            } else
                canMove = false;
        }
    }

    //System.out.println();
    //printArray(cell);

    System.out.println(R);

    in.close();
}

static boolean isSet(BitSet[] cell, int x, int y) {
    BitSet b = cell[x];
    return b.get(y);
}
static void set(BitSet[] cell, int x, int y) {
    BitSet b = cell[x];
    b.set(y);
}

static void printArray(int[][] arr) {
    for (int row = 0; row < arr.length; row++) {
        for (int col = 0; col < arr.length; col++)
            System.out.print(arr[row][col]);
        System.out.println();
    }
}
}