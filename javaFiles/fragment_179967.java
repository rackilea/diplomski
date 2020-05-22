public static void printMatrix (int columnStart, int rowStart, int columnSize, int rowSize, int[][] matrix) {
    if (columnStart+columnSize>matrix[0].length) return;
    if (rowStart+rowSize>matrix.length) return;
    for (int i=rowStart;i<rowStart+rowSize;i++) {
      for (int j=columnStart;j<columnStart+columnSize;j++) {
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("*********next********");
  }

  public static void printAllSubMatrices (int[][] matrix) {
    for (int i=0;i<matrix.length;i++) {
      for (int m=1;m<matrix.length-i+1;m++) {
        for (int j=0;j<matrix[0].length;j++) {
          for (int n=1;n<matrix[0].length-j+1;n++) {
            printMatrix(j, i, n, m, matrix);
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    //This will print you all the 36 sub-matrices of 3X3 matrix
    printAllSubMatrices(matrix);
  }