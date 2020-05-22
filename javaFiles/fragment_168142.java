public void randomStudy()
{
    int total = 0;
    int max = -1;
    int min = 11;
    int iterations = 1000;
    Random ran = new Random();
    for(int i = 0; i < iterations; i++)
    {
        int count = ran.nextInt(11);
        min = Math.min(count, min);
        max = Math.max(count, max);
        total += count;
    }

    System.out.println("Result of max: " + max);
    System.out.println("Result of min: " + min);
    System.out.println("Average: " + (1.0 * total / iterations));
}