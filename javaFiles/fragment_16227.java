int64 computeStringMask(String s)
{
    int64 mask = 0;
    // add individual letters to bitmask:
    for(int i = 0; i < s.length; i++)
    {
        mask |= 1 << (s[i]-'a');
    }
    // add "followed by" letter combinations to bitmask:
    for(int i = 0; i < s.length-1; i++)
    {
        for(int j = i+1; j < s.length; j++)
        {
            mask |= 1 << (((((s[i]-'a') * 26) + (s[j]-'a')) % 37) + 26);
        }
    }
    return mask;
}