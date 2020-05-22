public String getconvertdate1(String date)
{
    DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
    Date parsed = null; // should not be initialized first else current date will be printed in case of a parse exception
    try
    {
        parsed = inputFormat.parse(date);
    }
    catch (ParseException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    String outputText = outputFormat.format(parsed);
    return outputText;
}