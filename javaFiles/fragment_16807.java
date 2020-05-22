public static void main(String[] args) {
        // TODO code application logic here
        int[][] Board=new int[9][9];
        for(int i=0;i<Board.length;i++)
            for(int j=0;j<Board.length;j++)
                Board[i][j]=((i+1)*(j+1));

         for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board.length;j++)
                 System.out.print(Board[i][j]+" ");
             System.out.println("");
         }
        System.out.println("$$$$");
        int index=1;

        System.out.println(Arrays.toString(copyColumn(1, Board)));
        System.out.println(Arrays.toString(flip(Board)[index]));
    }
    public static int[] copyColumn(int index, int[][] Board)
    {
        int[] result=new int[9]; int k=0;
        for(int i=0;i<Board.length;i++)
            for(int j=0;j<Board.length;j++)
                if(j==index)
                {
                   result[k]=Board[i][j];
                   k++;
                }
        return result;
    }

    public static int[][] flip(int[][] Board)
    {
        int[][] result=new int[Board.length][Board.length];
        for(int i=0;i<Board.length;i++)
            for(int j=0;j<Board.length;j++)
                result[i][j]=Board[j][i];

        return result;
    }