public static void main(String[] args)
{
    int n = 1000000;
    int numSamples = 10000;
    long sumTime = 0;
    for (int i = 0; i < numSamples; i++)
    {
        sumTime += test(n);
    }
    double average = sumTime / (double) numSamples;
    System.out.println(average);
}

private static long test(int size)
{
    long start = System.currentTimeMillis();
    int[] a = new int[size];
    return System.currentTimeMillis() - start;
}