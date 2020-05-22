public static long shapes(int n)
    {
        if (n == 0) return 1;
        if (n == 1) return 1;
        long result = 0;
        for (int i = 0; i < n; i++)
        {
            result = result + shapes(i) * shapes(n - i - 1);
        }
        return result;
    }