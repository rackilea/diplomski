import java.util.Scanner;

public class Prime
{
    boolean flag = true;
    public boolean isPrime(int x)
    {
        for (int i = 2; i < x/2; i++)
        {
            if (x % i == 0)
            {
                return false;
            }  
        }
        return flag;
    }
    public static void main(String [] abc)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an number. A prime number preceeding and succeeding that number will be displayed.");
        int num = sc.nextInt();

        Prime p = new Prime();

        for (int j = num-1; j > 0; j--)
        {
            if (p.isPrime(j))
            {
                System.out.println("Prime number predeceeding " + num + " : " + j);
                break;
            }
        }
        for(int j=num+1; ;j++)
        {
            if (p.isPrime(j))
            {
                System.out.println("Prime number succeeding " + num + " : " + j);
                break;
            }
        }
    }
}