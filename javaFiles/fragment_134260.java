public static int isBalanced2(String s, int i, char match)
{
    if(i >= s.length())
        return match == '\0' ? 0 : -1;

    char c;
    int j;
    for(j = i; j < s.length(); j++)
    {
        c = s.charAt(j); 
        /* any of the closing type */
        if(c == ']' || c == '}' || c == ')') {
            return c == match ? j : -1;
        }

        if(c == '{') 
            j = isBalanced2(s, j + 1, '}');

        else if(c == '[')
            j = isBalanced2(s, j + 1, ']');

        else if(c == '(')
            j = isBalanced2(s, j + 1, ')');

        if(j == -1)
            break;
    }

    return match != '\0' ? -1 : j;
}