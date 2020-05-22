public static Object[][] transpose(Object[][] a)    
{
    Object[][] trans = new Object[a[0].length][a.length];
    if (a.length > 0)
    {
        for( int i = 0; i < a[0].length; i++)
            {
            for(int j=0; j<a.length; j++)
                {
                    trans[i][j] = a[j][i];
                }
            }
    }
    return trans;  
}