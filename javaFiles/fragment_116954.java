char *GetBytesString(char message[])
{
    short str_len = strlen(message);
    char *ptr = (char *) malloc(str_len * 2);
    int i;
    for (i = 0; i < str_len; i++)
    {
        int pos = i * 2;
        if (message[i] == '#')
        {
            ptr[pos] = 0;
            ptr[pos + 1] = 0;
        }
        else
        {
            ptr[pos] = 0;
            ptr[pos + 1] = message[i];
        }
    }
    return ptr;
}