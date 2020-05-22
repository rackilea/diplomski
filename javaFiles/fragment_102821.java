public static String allPowers(long a, long b)
{
    StringBuilder powers = new StringBuilder();
    long number = a;
    while (number <= b)
    {
        powers.append(Math.pow(2, number)).append(" ");
        number++;
    }
    return powers.toString();
}