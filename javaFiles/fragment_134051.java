public static void sort (double num [], String[] labels )
{
    int i, j; 
    double temp; 
    for ( i=0; i< num.length-1; i++ ) 
    {
        for ( j=i+1; j <num.length; j++ )
        {
            if( num[i] > num[j] ) 
            {
                temp = num[i];
                num[i] = num[j];
                num[j] = temp; 
                // ----------------- here -------------------
                String tmp = labels[i];
                labels[i] = labels[j];
                labels[j] = tmp; 
            } 
        }
    }
}