import java.util.Scanner;

public class CHP4Ex
{
     public static void main(String[] args)
     {
          Scanner scan = new Scanner(System.in);
          System.out.println("enter a n: ");
          int n = scan.nextInt();
          int i=0;
          int sum=0;
          while (i<=n)
          {
              if (i%2 == 0)
              {
                  sum = sum + i;
              }
              i++;
          }
          System.out.println(sum);
     }
}