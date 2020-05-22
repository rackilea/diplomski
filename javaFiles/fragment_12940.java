class Stockroom {

    public static boolean checkFeasibility(int x, int y, int row, int col,
            char a[][]) {
        if (x >= 0 && x < row && y >= 0 && y < col && a[x][y] != 'D')
            return true;

        else
            return false;
    }

    public static boolean shortestPath(char a[][], int bx, int by, int x,
            int y, int len, int minLen) {
        if (checkFeasibility(bx, by, x, y, a) == false)
            return false;

        if (a[bx][by] == 'C') {
            minLen = Math.min(len, minLen);
            System.out.println(minLen - 1);
            return true;
        }

        len++;

        if (len >= minLen) { // this was not shortest
            return false;
        }

        // hack to make sure we don’t go through the same spot again
        a[bx][by] = 'D';

        if (shortestPath(a, bx + 1, by, x, y, len, minLen) == true) {
            // remove temporary block so this space can be used in other paths
            a[bx][by] = '_';
            return true;
        }

        if (shortestPath(a, bx, by + 1, x, y, len, minLen) == true) {
            a[bx][by] = '_';
            return true;
        }

        if (shortestPath(a, bx, by - 1, x, y, len, minLen) == true) {
            a[bx][by] = '_';
            return true;
        }

        if (shortestPath(a, bx - 1, by, x, y, len, minLen) == true) {
            a[bx][by] = '_';
            return true;
        }

        len--;
        return false;

    }

    public static void main(String[] args) {
        // find path from B to C; don’t go through D
        char arr[][] = { { '_', 'B', '_', '_' }, 
                         { 'D', '_', '_', 'D' },
                         { '_', 'D', '_', '_' },
                         { '_', '_', 'C', '_' },
                        };

        int bx = 0, by = 1, px = 3, py = 2;
        int n = 4, m = 4;

        shortestPath(arr, bx, by, m, n, 0, 100);
        System.out.println(Arrays.deepToString(arr));
    }
}