public class Solution
{
    public static void main(String[] args)
    {
        final Solution solution = new Solution();
        for (int i = 1; i < 25; i++)
        {
            System.out.println(i + " has " + solution.count_factors(i) + " factor(s)");
        }
    }

    public int count_factors(int N)
    {
        int result = 0;
        final int sqrtN = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrtN; i++)
        {
            if (N % i == 0)
            {
                // We found 2 factors: i and N/i.
                result += 2;
            }
        }
        if (sqrtN * sqrtN == N)
        {
            // We counted sqrtN twice.
            result--;
        }
        return result;
    }
}