StringBuilder sb = new StringBuilder();
for (char c : myString.toCharArray())
{
    switch(c)
    {
        case '[':
        case ']':
        case '.':
        case '^':
        case '+':
        case '\\':
            sb.append('\\');
            // intended fall-through
        default:
            sb.append(c);
    }
}
String escaped = sb.toString();