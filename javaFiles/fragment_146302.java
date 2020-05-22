private static void merge(int[]a,int[]b,int[]c)
{
    int i = 0, j = 0, k = 0; 
    while((i < b.length) && (j < c.length))
    {
        if(b[i] < c[j])
        {
            a[k++] = b[i++];   
        }
        else
        {
            a[k++] = c[j++];
        }
    }
    while( i < b.length)
    {
        a[k++] = b[i++];
    }

    while( j < c.length)
    {
        a[k++] = c[j++];
    }
}