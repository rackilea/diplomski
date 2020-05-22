int numMatches = 0;
for (int i = 0; i < a.length; ++i)
{
    for (int j = 0; j < b.length; ++j)
    {
        if (a[i] == b[j])
            ++numMatches; //Naive, as obviously if the same number appears twice in a it'll get counted twice each time it appears in b.
    }
}