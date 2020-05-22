public class Test {

    public static final int SIZE_DIM1 = 2;
    public static final int SIZE_DIM2 = 2;
    public static final int SIZE_DIM3 = 5;
    public static final int SIZE_DIM4 = 5;
    private static final int INCREMENT = 2;

    public static void main(String[] args) {
        int[][][][] w = new int[SIZE_DIM1][SIZE_DIM2][SIZE_DIM3][SIZE_DIM4];

        randomFill(w);

        display(w);

        int[][][][] wNew = new int[SIZE_DIM1 + INCREMENT][SIZE_DIM2 + INCREMENT][SIZE_DIM3][SIZE_DIM4];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                System.arraycopy(w[i][j], 0, wNew[i][j], 0, w[i][j].length);
            }
        }

        display(wNew);

        w = wNew;

        w[0][3][4][4] = 1;

    }

    public static void randomFill(int[][][][] w) {
        Random random = new Random();
        for (int[][][] w2 : w) {
            for (int[][] w3 : w2) {
                for (int[] w4 : w3) {
                    for (int i = 0; i < w4.length; i++) {
                        w4[i] = random.nextInt();
                    }
                }
            }
        }
    }

    public static void display(int[][][][] w) {
        System.out.println("Printing---------------------------------------------------------------------------------");


        System.out.print("[\n");
        for (int[][][] w2 : w) {
            System.out.print("\t[\n");
            for (int[][] w3 : w2) {
                System.out.print("\t\t[\n");
                for (int[] w4 : w3) {
                    System.out.print("\t\t\t[");
                    for (int element : w4) {
                        System.out.print(element + " ");
                    }
                    System.out.print("]\n");
                }
                System.out.print("\t\t]\n");
            }
            System.out.print("\t]\n");
        }
        System.out.print("]\n");

    }

}