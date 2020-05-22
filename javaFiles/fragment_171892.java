public void populate()
{
    table = new int[3][7];

    for(int r=0;r<table.length;r++)
    {
        for(int c=0;c<table[0].length;c++)
        table[r][c]=r+c;
    }

}