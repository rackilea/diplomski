for (a = 0; a < dval.length; a++) // Determines sequence location of first second and third highest numbers
{
    if (dval[a] == high)
    {
        high = a+1;
    }
    if (dval[a] == sec)
    {
        sec = a+1;
    }
    if (dval[a] == thr)
    {
        thr = a+1;
    }
}