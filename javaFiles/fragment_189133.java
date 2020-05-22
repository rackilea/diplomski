long long weight[] = {generate some random numbers};
long long Hash(char * s, int length)
{
    long long result = 0;
    int i = 0, j = 0;
    while (i < length)
    {
        result += s[i] * weight[j ++];
        i += j;
    }
    return result & ((1 << 30) - 1);    // assume that your hash table has size 2^30
}