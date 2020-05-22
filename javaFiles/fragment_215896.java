if (length == 1)
{
    char c = buffer[index];
    if (c >= '0' && c <= '9')
    {
        return c - '0';
    }
    // Invalid - throw an exception or whatever
}