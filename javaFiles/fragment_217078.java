public static void fillSequentialMatrix2D(int [][]matrix) {
    for(int j=0, k=0; j<matrix.length ;j++){
        for(int i=0; i<matrix.length ;i++){
            matrix[i][j] = k++;
            //System.out.print("\t" + matrix[j][i]);
        }     
       // System.out.println();
    }
    for(int j = 0; j < matrix.length; j++)
    {
        for(int i = 0; i < matrix.length; i++)
            System.out.print("\t" + matrix[j][i]);
        System.out.println();
    }
}