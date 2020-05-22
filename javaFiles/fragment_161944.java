public static void trya (int a, int b, int c)
{
    if (c>(a+b))
    {
        System.out.println ("yes") ;
    }
    else if (b>(a+c)) 
    {
        System.out.println ("yes") ;
    }
    else if (a>(b+c))
    {
        System.out.println ("yes") ;
    }
    else
    {
        System.out.println ("no") ;
    }
}