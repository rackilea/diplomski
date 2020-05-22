private int getKeyOf(int year)
{
    switch (year / 100 % 4)
    {
        case 0:
            return 2;
        case 1:
            return 5;
        case 2:
            return 3;
        case 3:
            return 1;
    }
    return -1;
}