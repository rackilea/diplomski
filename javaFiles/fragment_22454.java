public class Main
{
    public static int p(int x, int n) 
    {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return p(x, (n / 2)) * p(x, (n / 2));
        else
            return x * p(x, ((n - 1) / 2)) * p(x, ((n - 1) / 2));
    }

    public static void main(String[] args)
    {
        System.out.println(Main.p(2, 3));
    }