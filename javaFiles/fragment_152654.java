int size = 3;
    int numRows = (int)Math.pow(2, size);
    boolean[][] bools = new boolean[numRows][size];
    for(int i = 0;i<bools.length;i++)
    {
        for(int j = 0; j < bools[i].length; j++)
        {
            int val = bools.length * j + i;
            int ret = (1 & (val >>> j));
            bools[i][j] = ret != 0;
            System.out.print(bools[i][j] + "\t");
        }
        System.out.println();
    }