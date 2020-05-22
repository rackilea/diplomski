String[] formats = { "dd MMM. yyyy", "dd MM yyyy" };

for (String format : formats)
{
    try
    {
        return new SimpleDateFormat( format ).parse( theDateString );
    }
    catch (ParseException e) {}
}