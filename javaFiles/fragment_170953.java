private static String getEntry(String input, int which)
{
    int left, right = -1;
    do {
        left = right;
        right = input.indexOf('^', right+1);
    }
    while(which-- > 0 && right >= 0);

    if(which != -1)
        return null;

    if(right == -1)
        return input.substring(left+1);

    return input.substring(left+1, right);
}