public class AdjacencyMatrix {
    public static final int NUM_NODES = 100;
    public static final int INF = 99999;
    public static final int A = 20;
    public static final int B = 18;
    public static final int C = 47;
    public static final int D = 44;
    public static final int E = 53;
    public static final int F = 67;
    public static final int G = 95;
    public static final int H = 93;
    public static final int I = 88;
    public static final int W = 66;

    public static boolean even(int num) {
        return num % 2 == 0;
    }

    public static boolean odd(int num) {
        return num % 2 == 1;
    }

    public static void initialize(int[][] adjMat) {
        for (int i = 0; i < adjMat.length; i++)
            for (int j = 0; j < adjMat.length; j++) {
                if (i == j) {
                    adjMat[i][j] = 0;
                } else {
                    adjMat[i][j] = INF;
                }
            }

        for (int x = 0; x < adjMat.length; x++) {
            int row = x / 10;
            int column = x % 10;

            if (even(row)) {
                if (column != 9)
                    adjMat[x][x + 1] = 1;
            }
            if (odd(row)) {
                if (column != 0)
                    adjMat[x][x - 1] = 1;
            }
            if (even(column)) {
                if (row != 9)
                    adjMat[x][x + 10] = 1;
            }
            if (odd(column)) {
                if (row != 0)
                    adjMat[x][x - 10] = 1;
            }
        }
    }

    public static void floydWarshall(int[][] adjMat) {
        // commented this out because you are also allocating
        // adjMat in the main method. 
        //adjMat = new int[adjMat.length][adjMat.length];
        initialize(adjMat);

        for (int k = 0; k < adjMat.length; ++k) {
            for (int i = 0; i < adjMat.length; ++i) {
                for (int j = 0; j < adjMat.length; ++j) {
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }

        //return adjMat;
    }

    public static int[][] arrayCondenser(int[][] adjMat, int [] array) {
        int[][] condensedArray = new int[array.length][array.length];
        //adjMat = floydWarshall(adjMat, N);

        for (int storeFrom = 0; storeFrom < array.length; storeFrom++) {
            for (int storeTo = 0; storeTo < array.length; storeTo++) {
                condensedArray[storeFrom][storeTo] = adjMat[array[storeFrom]][array[storeTo]];
            }
        }

        return condensedArray;
    }

    public static void printGrid(int[][] adjMat) {
        System.out.println("Adjacency Matrix: ");
        System.out.printf("%5s", " ");
        for (int i = 0; i < adjMat.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.printf("%4s+", " ");
        for (int i = 0; i < adjMat.length; i++) {
            System.out.printf("%5s", "===");
        }
        System.out.println();
        for (int i = 0; i < adjMat.length; ++i) {
            System.out.printf("%4d|", i);

            for (int j = 0; j < adjMat[i].length; ++j) {
                if (adjMat[i][j] == INF)
                    System.out.printf("%5s", "INF");
                else
                    System.out.printf("%5d", adjMat[i][j]);
            }
            System.out.println();
        }
    }
    public static void printCondensedGrid(int[][] adjMat, int stores[]) {
        System.out.println("Condensed grid: ");
        System.out.printf("%5s", " ");
        for (int i = 0; i < stores.length; i++) {
            System.out.printf("%5d", stores[i]);
        }
        System.out.println();
        System.out.printf("%4s+", " ");
        for (int i = 0; i < adjMat.length; i++) {
            System.out.printf("%5s", "===");
        }
        System.out.println();
        for (int i = 0; i < adjMat.length; ++i) {
            System.out.printf("%4d|", stores[i]);

            for (int j = 0; j < adjMat[i].length; ++j) {
                if (adjMat[i][j] == INF)
                    System.out.printf("%5s", "INF");
                else
                    System.out.printf("%5d", adjMat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int adjMat[][] = new int[NUM_NODES][NUM_NODES];
        int[] stores = { A, B, C, D, E, F, G, H, I, W };

        floydWarshall(adjMat);

        printGrid(adjMat);
        int condensedArray[][] = arrayCondenser(adjMat, stores);
        printCondensedGrid(condensedArray, stores);

        System.out.println();
    }
}