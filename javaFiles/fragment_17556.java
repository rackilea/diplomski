public static int[][] matrixGen(){
    Random r = new Random( );
    for(int i=0; i < matrix.length; i++){
        for(int j=0; j < matrix[i].length; j++){
            matrix[i][j] = r.nextInt( 100 );
        }
    }
    return matrix;
}