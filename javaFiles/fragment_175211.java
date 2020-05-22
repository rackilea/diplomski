public static void fillMatrix(int [][] pmatrix) throws IOException {
    for(i = 0; i < pmatrix.length; i++){
        for(int j = 0; j < pmatrix[i].length; i++ {
            print.println("set the value of row " + (i + 1) + " in column " + (j + 1));
            pmatrix[i][j] = Integer.parseInt(read.readLine());    
        }               
    }
}