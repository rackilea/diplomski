String[] splitBuffer(StringBuffer input, int maxLength)
{
    int elements = (input.length() + maxLength - 1) / maxLength;
    String[] ret = new String[elements];
    for (int i = 0; i < elements; i++)
    {
        int start = i * maxLength;
        ret[i] = input.substring(start, Math.min(input.length(),
                                                 start + maxLength));
    }
    return ret;
}