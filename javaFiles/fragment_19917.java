boolean isHumble(int n)
{
    if (isFactor(n)) return true;
    for(int i=2;i<=n/2;i++)
    {
        while(n%i == 0)
            if (isFactor(i))
                n /= i;
            else
                return false;
    }
    return isFactor(n);
}