public static int recaman(int n)
        {
            int[] seq = new int[n];
            boolean[] check = new boolean[10 * n];

            seq[0] = 0;
            check[0] = true;
            for (int k = 1; k < n; k++)
            {
                int minusVal = seq[k - 1] - k;
                int plusVal = seq[k - 1] + k;
                if ((minusVal > 0) && (!check[minusVal]))
                {
                    seq[k] = minusVal;
                    check[minusVal] = true;
                } else
                {
                    seq[k] = plusVal;
                    check[plusVal] = true;
                }
            }
            return seq[n - 1];
        }