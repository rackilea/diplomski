public void printseries(int a, int b)
    {
        for (int i = 1; i <= 2 * b; i*=2)
        {
            int k = 0;
            k = a * i;
            for (int j = 1; j <= i; j++)
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