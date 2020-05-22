public static long park(int n)
{
    if(n==1)
        { return 2; }
    else if(n==2)
        { return 5; }
    else if(n==3)
        { return 13; }
    else
        {
        return (park(n-1) + park(n-1) + park(n-2) + park(n-3));
        }
}