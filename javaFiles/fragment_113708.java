private static final String NAMESPACE = "http://www.kltro.com";
private static final String METHODNAME = "getOutlets";
private static final String WSDL = "http://mapx.kashkan.org:5445/tro/ws/kltro";
private static final String SOAP_ACTION = NAMESPACE + "#kltro:" + METHODNAME;
private static String TAG = "soap_tester";

public static String callWebservice() {
    String responseDump = "";
    try {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        // Register the Date Marshal class
        new MarshalDate().register(envelope);

        SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
        request.addProperty("userId", "a24f0c23-5f36-11e4-b332-984be174a0cc");

        // Your date
        String dateStr = "2016-08-25";

        // Parse the date into an object of type java.util.Date
        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        // You might want to play around with the timezones
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("ru"), Locale.ENGLISH);
        calendar.setTime(sdfIn.parse(dateStr));

        // Clear the hour, minute and second
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();;

        // Create a property with the date object and type as java.util.Date.class
        PropertyInfo dateProperty = new PropertyInfo();
        dateProperty.setValue(date);
        dateProperty.setName("date");
        dateProperty.setType(Date.class);

        // Add it to the request
        request.addProperty(dateProperty);

        envelope.bodyOut = request;
        HttpTransportSE transport = new HttpTransportSE(WSDL);
        transport.debug = true;
        try {
            transport.call(SOAP_ACTION, envelope);
            String requestDump = transport.requestDump;
            responseDump = transport.responseDump;
            Log.e(TAG, requestDump);
            Log.e(TAG, responseDump);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return responseDump;
}