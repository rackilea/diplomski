public static boolean checkPrime(int num, int i)
{
    if (i == num)
        return true;    
    else
    {
        if (num % i == 0)
            return false;
        else
            return checkPrime(num, i+1);
    }
}