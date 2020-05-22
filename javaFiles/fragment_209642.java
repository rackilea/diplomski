public class Primtal
{
    public static boolean isPrime(int n) 
    {
        int i = 2;

        if(n == 2)
        {
            return true;    
        } 

        while(i < n)
        {
            if(n % i == 0)
            {
                return false;
            }

            i++;
        }

        return true;
    }

    public static void main(String[] args)
    {
        for(int i = 3; i < 1000; i++)
        {
            if(isPrime(i))
            {
                System.out.print(i);
            }
        }
    }
}