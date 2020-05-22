import java.util.Scanner;
public class array_input
{
    public static void main(String [] args){
         int a [][] = new int[2][2];
         Scanner scan = new Scanner(System.in);

         for(int i = 0;i < 2; i++){
              for(int j = 0; j < 2; j++){
                   System.out.printf("input number[%d][%d]=", i, j);
                   int b = scan.nextInt();
                   a[i][j]=b;
              }
         }
         System.out.print("input last = ");
         int needle = scan.nextInt();

         for (int[] row : a){
              for (int col : row){
                   if(col == needle){
                        System.out.println("found");
                        return;
                   }
              }
         }
         System.out.print("not found");
     }
}