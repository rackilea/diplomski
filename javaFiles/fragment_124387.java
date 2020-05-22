public class ModifiedFib
{
    static BigInteger Fib(int a1, int a2, int i)
    {
        if (i <= 0)
            return BigInteger.ZERO;
        else if (i == 1)
            return BigInteger.valueOf(a1);
        else if (i == 2)
            return BigInteger.valueOf(a2);
        else
        {
            BigInteger b1 = Fib(a1, a2, i - 1);
            BigInteger b2 = Fib(a1, a2, i - 2);

            return b1.multiply(b1).add(b2);
        }
    }

    public static void main(String[] args)
    {
        for (int i = -1; i <= 11; i++)
            System.out.println("i = " + i + ": " + Fib(0, 1, i));
    }
}