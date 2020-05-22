public static char[] StringReverse(char[] x , int startindex)
{
    int p = x.length;
    if(startindex < p/2)
    {
        char temp = x[startindex];
        x[startindex] = x[x.length - startindex-1];
        x[x.length - startindex-1] = temp;
        return StringReverse(x , startindex+1);
    }
    else
    {
        return x;
    }
}