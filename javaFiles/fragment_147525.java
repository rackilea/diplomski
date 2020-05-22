public static int[] eMOF(int[] randomNumbers)
{
    int[] eMOFArray = new int[100];
    int i = 0;
    for (int x : randomNumbers)
    {
        if ( x % 4 == 0 && ( x / 4 ) % 2 == 0)
        {       
            eMOFArray[i++] = x;
        }
    }
    return eMOFArray;
}


public static int[] oMOF(int[] randomNumbers)
{
    int[] oMOFArray = new int[100];
    int i = 0;
    for (int x : randomNumbers)
    {
        if ( x % 4 == 0 && ( x / 4 ) % 2 != 0)
        {   
            oMOFArray[i++] = x;
        }   
    }
    return oMOFArray;
}