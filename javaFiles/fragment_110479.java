public class Main {
        public static void main(String[] args) {
            int[][] a = {{1,1},{1,1}};
            int[][] b = {{2,2},{2,2}};

        int[][] c = new int[2*a.length][a.length];

        for(int i = 0; i < 2*a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i < a.length) {
                    c[i][j] = a[i][j];
                } else {
                    c[i][j] = b[i - a.length][j];
                }
            }
        }
    }

}