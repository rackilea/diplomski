for(int j = 1; j < b.length; j++)
{
    if (j < numberdel)
        b[j] = v[j];
    else
        b[j] = v[j + 1];
}