private static Dictionary<int, System.Numerics.BigInteger> results = 
        new Dictionary<int, System.Numerics.BigInteger>();

    public static System.Numerics.BigInteger shapes(int n)
    {
        if (n == 0) return 1;
        if (n == 1) return 1;
        System.Numerics.BigInteger result = 0;
        for (int i = 1; i <= n; i++)
        {
            System.Numerics.BigInteger left = 0;
            System.Numerics.BigInteger right = 0;
            if (!results.ContainsKey(i - 1))
            {
                left = shapes(i - 1);
                results[i - 1] = left;
            }
            else
            {
                left = results[i - 1];
            }

            if (!results.ContainsKey(n - i))
            {
                right = shapes(n - i);
                results[n - i] = right;
            }
            else
            {
                right = results[n - i];
            }

            result +=  left * right;
        }
        return result;
    }