boolean canMakeStringViaInsertions(s, word)
{
    int i = 0; j = 0;
    while(word[j] != 0)
    {
        if(s[i] == word[j])
        {
            // match!
            i++;
            if(s[i] == 0)
                return true;   // all chars have matched
        }
        j++;
    }
    return false;
}