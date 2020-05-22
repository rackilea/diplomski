if ((iYear % 4 == 0) && (iYear % 100 != 0) || (iYear % 400 == 0)

    {
        blnLeapYear = true;
    }
    else 
    {
        blnLeapYear = false;
    }