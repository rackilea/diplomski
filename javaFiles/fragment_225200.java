public class MyGlobals
{
    private static SimpleDateFormat dateFormat;


    public static SimpleDateFormat getDateFormat()
    {
        if(dateFormat== null)
        {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return dateFormat;

    }
}