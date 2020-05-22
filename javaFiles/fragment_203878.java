public class Main{

    static double[][] mat;

    public static void main(String[] args){
           Scanner input=new Scanner(System.in);
           System.out.println("Enter number of rows and number of columns");

           int n=input.nextInt();
           int m=input.nextInt();
           mat=new double[n][m];
           System.out.println("Please enter elements of matrix");

           for(int i=0;i<n;i++){
               for(int i=0;i<m;i++){
                   mat[i][j]=input.nextDouble();
               }
           }

          System.out.println("Enter column number to get sum");
          double sum=0D;
          int col=input.nextInt();
          for(int i=0;i<m;i++){
              sum+=mat[i][col];
          }

         System.out.println("sum of elements of "+col+"in the mat is "+sum);
    }
}