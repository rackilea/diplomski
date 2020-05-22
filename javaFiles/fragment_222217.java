String[][] matrix = {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
String[][] tmp = new String[matrix.length][matrix.length];

    //PRINT BEFORE ROTATION
for(int row=0; row<matrix.length;row++){
    for(int col=0; col<matrix.length;col++){
        System.out.print(matrix[row][col] + "  ");
    }
    System.out.println();
}

    //HERE IS THE ROTATION
for(int row=0; row<matrix.length;row++){
    for(int col=matrix.length-1; col>=0;col--){
        tmp[col][row] = matrix[row][matrix.length-1-col];
    }
}

    //PRINT AFTER ROTATION
System.out.println("Rotated");
for(int row=0; row<matrix.length;row++){
    for(int col=0; col<matrix.length;col++){
        System.out.print(tmp[row][col] + "  ");
    }
    System.out.println();
}