public class DateTest {

    private static SimpleDateFormat soapdatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    /**
     * @param args
     */
    public static void main(String[] args) {
        TimeZone oztz = TimeZone.getTimeZone("Australia/Sydney");
        TimeZone gmtz = TimeZone.getTimeZone("GMT");
        Calendar datetime = Calendar.getInstance( gmtz );

        soapdatetime.setTimeZone( gmtz );
        String soap_datetime = soapdatetime.format( datetime.getTime() );
        System.out.println( soap_datetime );

        soapdatetime.setTimeZone( oztz );
        datetime.setTimeZone( oztz );
        try {
            datetime.setTime(
                    soapdatetime.parse( soap_datetime )
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        soapdatetime.setTimeZone( gmtz );
        soap_datetime = soapdatetime.format( datetime.getTime() );
        System.out.println( soap_datetime );
    }
}