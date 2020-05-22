public static int nthPrime (int n)
{
    int i = 0;
    int nthcounter = 0;

    while (nthcounter != n) //when total prime number equal to 10000, stop loop
    {

        if(isPrime(i) == true)
        {
            nthcounter++;
        }
        i++;
    }
    return i;
}