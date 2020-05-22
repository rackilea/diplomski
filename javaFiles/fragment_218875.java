public class TwoDimensional {
        private int i, j, k = 0;
        int[][] twod = new int[4][5];

        public void DoubleT() {
            for (i = 0; i < 4; i++)
                for (j = 0; j < 5; j++) {
                    twod[i][j] = k;
                    k++;
                      }
                }
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 5; j++){
                    System.out.print(twod[i][j] + " ");
                               }
                System.out.println();     
                       }
    }