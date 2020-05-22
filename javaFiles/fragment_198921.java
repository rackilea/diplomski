// ...
List<String> formatStrings = Arrays.asList("M/y", "M/d/y", "M-d-y");
// ...

Date tryParse(String dateString)
{
    for (String formatString : formatStrings)
    {
        try
        {
            return new SimpleDateFormat(formatString).parse(dateString);
        }
        catch (ParseException e) {}
    }

    return null;
}