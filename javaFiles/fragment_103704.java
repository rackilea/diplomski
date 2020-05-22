public boolean checkDelayed(Date date1, Date date2)
{
    long difference = date2.getTime() - date1.getTime();

    if (difference <= 345600000L)
    {
        return true;
    }

    return false;
}