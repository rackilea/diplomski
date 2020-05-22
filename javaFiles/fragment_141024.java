import java.util.Scanner;

public class CHP4Ex
    {

        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter a n: ");
            int n = scan.nextInt();
            int i=10;
            while (i<n)
            {
                System.out.println(i);
                i = i + 10;
            }
        }
}