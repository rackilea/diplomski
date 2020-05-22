for(int x = 0; x < word.length(); x++)
{
    test = word.substring(x, x+1); 
    if (test.equals(character))
    {
        c += 1;
    }
}