public static int maxFGP(int[] fgm, int[] fga, int count)
{
    int max = 0;
    double maxValue=(1.0 * fgm[0]) / (1.0 * fga[0]) * 100;
    for(int i = 0; i < count; i++)
    {
        if((1.0 * fgm[i]) / (1.0 * fga[i]) * 100 > maxValue)                                                      
        {
            max = i;  
            maxValue=(1.0 * fgm[i]) / (1.0 * fga[i]) * 100;  
        }        
    }
    return max;
}