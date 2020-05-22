public static int partition(int[] value, int p, int r)
    {
            int x = value[p];
            int i = p - 1;
            int j = r + 1 ;

            while (true)
            {
                    do
                    {
                        j--;
                        comparisons++;
                    }
                    while (value[j] > x);

                    do
                    {
                        i++;
                        comparisons++;
                    }
                    while (value[i] < x);

                    if (i < j)
                    {
                        swap(value, i, j);
                    }
                    else
                            return j;
            }
    }