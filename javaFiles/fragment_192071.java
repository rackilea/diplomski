public class Queens
{
    static void printSolution (int [] queens)
    {
        int l = queens.length;
        for (int i = 0; i < l; i++)
        {
            for (int j = 0; j < l; j++)
            {
                System.out.print (queens [i] == j ? 'Q' : '.');
                System.out.print (' ');
            }
            System.out.println ();
        }
        System.out.println ();
    }

    static int placement (int [] queens, int c)
    {
        if (c == queens.length)
        {
            printSolution (queens);
            return 1;
        }
        else
        {
            int solutionCount = 0;
            int l = queens.length;

            for (int r = 0; r < l; r++)
            {
                boolean flag = false;
                for (int i = 0; i < c; i++)
                {
                    int xd = c - i;
                    int yd = Math.abs (r - queens [i]);

                    if (yd == 0 || xd == yd)
                    {
                        flag = true;
                        break;
                    }

                    // Knight move support
                    if ((xd == 1 && yd == 2) || (xd == 2 && yd == 1))
                    {
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                {
                    queens [c] = r;
                    solutionCount += placement (queens, c + 1);
                }
            }

            return solutionCount;
        }
    }

    public static void main (String [] args)
    {
        System.out.println (
            "Total solutions found: " + placement (new int [11], 0));
    }
}