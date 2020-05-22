for(int i = 0; i < a.length; i++)
{
    for(int j = 0; j < a[i].length; j++)
    {
        int temp = a[a.length-i-1][j];
        if (temp != 0) {a[i][j] = a[a.length-i-1][j];}
    }
}