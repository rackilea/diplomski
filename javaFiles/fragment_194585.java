int performComparison(char* string1, char * string2)
{
    char c1, c2;
    int  v;

    do {
        c1 = *string1++;
        c2 = *string2++;
        v = (UINT) tolower(c1) - (UINT) tolower(c2);
    } while ((v == 0) && (c1 != '\0') && (c2 != '\0') );

    return v != 0;
}