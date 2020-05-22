public int recurse(int first, int second, int n)
{
    switch (n)
    {
        case 0:  return first;
        case 1:  return second;
        default: return recurse(first, second, n - 1) + recurse(first, second, n - 2);
    }
}