while(n>no-1)
{
    long newN = n;

    if (n % 2 == 0) newN = newN / 2L;
    else newN = 3L * newN + 1L;

    if (newN > Integer.MAX_VALUE) System.out.println("about to fail");

    //this is where the magic happens
    n = (int)newN;
    System.out.println("converted " + newN + " to " + n);

    i++;
}