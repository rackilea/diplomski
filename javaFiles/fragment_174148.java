boolean containsLetter(char letter)
{
    for(Char c : word2)
    {
        if(c == letter)
            return true;
    }
    // We got here means no matches
    return false;
}