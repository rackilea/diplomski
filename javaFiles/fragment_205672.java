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
    arrTime[k] = arrTime[k - 1] + n;

    // Add a border around the matrix with values of 1
    int N = n + 2;
    int[][] cell = new int[N][N];
    for (j = 0; j < cell.length; j++) {
        cell[0][j] = 1;  // Top border
        cell[j][0] = 1;  // Left border
        cell[j][N - 1] = 1;  // Right border
        cell[N - 1][j] = 1;  // Bottom border
    }
    int nCurrRow = 1;
    int nCurrCol = 1;
    cell[nCurrRow][nCurrCol] = 1;
    long R = n * n - 1;  // Number of remaining unvisited cells

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
            if (cell[nCurrRow + yDir][nCurrCol + xDir] == 0) {
                nCurrRow += yDir;
                nCurrCol += xDir;
                cell[nCurrRow][nCurrCol] = 1;
                R--;
            } else
                canMove = false;
        }
    }

    //printArray(cell);

    System.out.println(R);

    in.close();
}

static void printArray(int[][] arr) {
    for (int row = 0; row < arr.length; row++) {
        for (int col = 0; col < arr.length; col++)
            System.out.print(arr[row][col]);
        System.out.println();
    }
}
}