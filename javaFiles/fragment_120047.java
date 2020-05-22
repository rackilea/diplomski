if ((year % 4 == 0) && (year % 100 != 0))
    {
        leap = true;
    }
    else if (year % 400 == 0)
    {
        leap = true;
    }
    else
    {
        leap = false;
    }