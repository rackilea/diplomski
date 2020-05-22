public static void q()
{
    // Init variables
    int[] x = new int[t];
    c = 0;
    d = 0;

    while(c != t)
    {
        x[c] = roll(sides);
        c++;
    }
    while(d != t)
    {
        System.out.println("You rolled " + x[d]);
        d++;
    }
}