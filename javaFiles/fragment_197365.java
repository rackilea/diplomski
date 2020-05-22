public static void main(String[] arg){
    System.out.println("Show matrix with loop, before fill");
    int[][] matrix = getMatrixWithWideLoop();
    printMatrix(matrix);
    System.out.println("Found loop: "+checkIfPositionIsInLoop(matrix, 0, 2, 2 /*fill with 2s*/));

    System.out.println("-----------------------------------------");
    System.out.println("Show matrix without loop, before fill");
    matrix = getMatrixWithoutLoop();
    printMatrix(matrix);
    System.out.println("Found loop: "+checkIfPositionIsInLoop(matrix, 0, 2, 2 /*fill with 2s*/));


    System.out.println("-----------------------------------------");
    System.out.println("Show matrix with small loop, before fill");
    matrix = getMatrixWithSmallLoop();
    printMatrix(matrix);
    System.out.println("Found loop: "+checkIfPositionIsInLoop(matrix, 0, 2, 2 /*fill with 2s*/));


    System.out.println("-----------------------------------------");
    System.out.println("Show matrix without loop, before fill");
    matrix = getMatrixWithoutLoop();
    printMatrix(matrix);
    System.out.println("Found loop: "+checkIfPositionIsInLoop(matrix, 0, 1, 2 /*fill with 2s*/));

}