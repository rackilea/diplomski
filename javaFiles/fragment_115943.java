for (String s in allStrings)
{
    int charClass = 0
    for (Char c in s.characters)
    {
        case c
            when upper-case: 
                charClas |= 8
                break;
            when lower-case: 
                charClas |= 4
                break;
            when numeric: 
                charClas |= 2
                break;                
            when punctuation: 
                charClas |= 1
                break;
    }
    // do something with charClass
}