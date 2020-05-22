public boolean checkDelayed(Date date1, Date date2)
{
    double difference = (double) (date2.getTime() - date1.getTime());

    if (difference / 1000d / 60d / 60d / 24d <= 4d)
    {
        return true;
    }

    return false;
}