public static String factors(int n)
{
    String ans = "";
    int count = 0;
    for (int i = 2; i <= n; i++)
    {
        // Reset the counter
        count = 0;

        /*
         * Instead of only processing on factor, we process them all and
         * count them
         */
        while (n % i == 0)
        {
            count++;
            n = n / i;
        }

        // If we have at least processed one add it to the string
        if (count == 1)
        {
            ans += "(" + i + ")";
        } else if (count > 0)
        {
            ans += "(" + i + "**" + count + ")";
        }
    }
    return ans;
}