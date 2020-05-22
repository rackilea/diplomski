import java.util.Scanner;

 class Matrix {

    private int rowNumber;
    private int colNumber;
    int[][] matrix;

    public Matrix() {
       rowNumber = 0;
       colNumber = 0;
    }

   public Matrix(int row, int col) {
       rowNumber = row;
       colNumber = col;
       matrix = new int[rowNumber][colNumber];

       Scanner input = new Scanner(System.in);
       for (int i = 0; i < rowNumber; i++) {
          for (int j = 0; j < colNumber; j++) {
              System.out.println("Enter A" + (i + 1) + "" + (j + 1) + " : ");
              setElement(i, j, input.nextInt());
          }
       }
       display();
    }

     public void setElement(int r, int c, int value) {
        matrix[r][c] = value;
     }

     public int getElement(int r, int c) {
        return matrix[r][c];
      }

     public void display() {

         String str = "|\t";
         for (int i = 0; i < rowNumber; i++) {
             for (int j = 0; j < colNumber; j++) {
                  str += getElement(i, j) + "\t";
             }
             System.out.println(str + "|");
             str = "|\t";
         }
    }

    public static void main(String[] args) {
      int rowNumber;
      int colNumber;
      Scanner input = new Scanner(System.in);

      System.out.println("Enter number of rows: ");
      rowNumber = input.nextInt();
      System.out.println("Enter number of columns: ");
      colNumber = input.nextInt();
      Matrix obj1 = new Matrix(rowNumber, colNumber);
   }
 }