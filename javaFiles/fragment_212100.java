public static int[] FibLength(int l)
{
    int fib[] = new int[l];
    fib[0] = 1;
    fib[1] = 1;

    for (int i=2; i<fib.length; i++)
        fib[i] = fib[i-1] + fib[i-2];

    return fib;
}