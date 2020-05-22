public void printseries(int a, int b)
    {
        for (int i = 1; i <= 2 * b; )
        {
            int k = 0;
            k = a * i;
            i *= 2;
            for (int j = 1; j <= i/2; j++)
            {
                if (j == 1)
                    System.out.print(k);
                else
                {   
                    k++;
                    System.out.print(" "+k);
                }
            }
            System.out.println();
        }
    }