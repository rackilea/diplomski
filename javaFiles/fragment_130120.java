String GetSuffix (int number)
{
    int lastTwoDigits = number % 100;

    if (lastTwoDigits == 11 || lastTwoDigits == 12 || lastTwoDigits == 13)
    {
        return "th";
    }

    switch (number % 10)
    {
    case 1:
        suffix = "st";
        break;
    case 2:
        suffix = "nd";
        break;
    case 3:
        suffix = "rd";
        break;
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 0:
        suffix = "th";
        break;

    default: break;
    }

    //This shouldn't happen
    return "";
}