while( x < 1000)
{
    if((x/3 == (int)x) || (x/5 == (int)x))
    {
        count++;
        x++;
        total += x;
    }
}