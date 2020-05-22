public static int[] splitToComponentTimes(BigDecimal biggy)
{
    long longVal = biggy.longValue();
    int hours = (int) longVal / 3600;
    int remainder = (int) longVal - hours * 3600;
    int mins = remainder / 60;
    remainder = remainder - mins * 60;
    int secs = remainder;

    int[] ints = {hours , mins , secs};
    return ints;
}