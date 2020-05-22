public class BruteForcePrimeNumberTester : PrimeNumberTest
{
    public bool isPrime(int value)
    {
        bool isPrime = true;

        for(int i = 2; isPrime && i < value; i++)
        {
            if (value % i == 0)
            {
                isPrime = false;
            }
        }

        return isPrime;
    }
}