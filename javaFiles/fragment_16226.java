boolean stringIsImpossible(String s)
{
    // test against 5 char bitfield:
    for(i = 0; i <= s.length - 5; i++)
    {
        index = ((s[i]-'a')*(26^4)) + ((s[i+1]-'a')*(26^3)) + ((s[i+2]-'a')*(26^2)) + ((s[i+3]-'a')*26) + (s[i+4]-'a');
        if(5charBitmask[index] == 0)
            return true;
    }
    if(s.length > 4)
        return false;
    // test against 4 char bitfield:
    for(i = 0; i <= s.length - 4; i++)
    {
        index = ((s[i]-'a')*(26^3)) + ((s[i+1]-'a')*(26^2)) + ((s[i+2]-'a')*26) + (s[i+3]-'a');
        if(4charBitmask[index] == 0)
            return true;
    }
    if(s.length > 3)
        return false;
    // test against 3 char bitfield:
    for(i = 0; i <= s.length - 3; i++)
    {
        index = ((s[i]-'a')*(26^2)) + ((s[i+1]-'a')*26) + (s[i+2]-'a');
        if(3charBitmask[index] == 0)
            return true;
    }
    return false;
}