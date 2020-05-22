while(n != 0)
{
    ld = n % 10;
    System.out.println(ld);
    f = 1; // reset f
    for ( i=1; i <= ld; i++)
    {
        f = f * i;
    }

    System.out.println(f);

    n /= 10;
}