class BreakWithLabelDemo {
    public static void main(String[] args) {

        int[][] img = { 
                    {55, 60, 65, 1},
                    {95, 90, 85, 5},
                    {5,  0,  8,  5},  
                    {53, 60, 89, -5}
        };


        int tile=2; 
        int row=4; 
        int col=4;
        int i, r;
        int j, c;

        tile = 2;
        for(i = 0; i < row; i= tile + i)
           for(j = 0; j < col; j= tile + j){
              for(r = 0; r < tile; r++){   
                 for(c = 0; c < tile; c++) 
                    System.out.print(" ", img[i+r][j+c]);
                 System.out.println("");
              }
              System.out.println("\n");
           }



        int img2[][] = { 
                  // 1   2   3   4  5  6  7  8  9 
                    {55, 60, 65, 1, 2, 4, 1, 4, 0},
                    {95, 90, 85, 5, 3, 6, 5, 0, 8},
                    {5,  0,  8,  5,-1, 2, 2, 5, 6},  
                    {95, 90, 85, 5, 3, 6, 5, 0, 8},
                    {55, 60, 65, 1, 2, 4, 1, 4, 0},
                    {5,  0,  8,  5,-1, 2, 2, 5, 6},  
                    {1,  2,  3,  4, 5, 6, 7, 8, 9}, 
                    {1,  2,  3,  4, 5, 6, 7, 8, 9}, 
                    {1,  2,  3,  4, 5, 6, 7, 8, 9}
                  };

         row = 9; 
         col = 9;
         tile = 3;

         for(i = 0; i < row; i= tile + i)
           for(j = 0; j < col; j= tile + j){
              for(r = 0; r < tile; r++){   
                 for(c = 0; c < tile; c++) 
                    System.out.print(" ", img[i+r][j+c]);
                 System.out.println("");
              }
              System.out.println("\n");
           }
    }
}