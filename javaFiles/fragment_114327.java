void Draw(int sqr)
        {
            int half = sqr/2;
            for (int row=0; row<sqr; row++)
            {
                for (int column=0; column<sqr; column++)
                {
                    if ((column == Math.abs(row - half)) 
                        || (column == (row + half)) 
                        || (column == (sqr - row + half - 1)))
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print("_");
                    }
                }
                System.out.println();
            }
        }