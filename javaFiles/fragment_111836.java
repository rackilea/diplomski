public static long factorial(int i)
{
    // This is the base case
    if(i == 0)
    {
         return 1;
    }
    else
    {
        // This reduces the problem to something closer to the base case
        return i * factorial(i - 1);
    }
}