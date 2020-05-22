public static string DoubleToStringFormat(double dval)
{
    long lval = (long)dval;
    if ((double)lval == dval)
    {
        // has no decimals: format as integer
        return dval.ToString("#.", CultureInfo.InvariantCulture);
    }
    else
    {
        // has decimals: keep them all
        return dval.ToString("0.##################", CultureInfo.InvariantCulture);
    }
}