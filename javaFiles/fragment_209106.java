private static final String NAMESPACE = "http://tempuri.org/" ;
private static final String URL = " http://IP/CardiacPortalWS/VitalInfoWS.asmx";
private static final String SOAP_ACTION = "http://tempuri.org/userLogin";
private static final String METHOD_NAME = "userLogin";
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("PatientID", "10");
        request.addProperty("Weight", "72");
        String currentDateTimeString = new SimpleDateFormat("yyyy-MM-dd").
            format(new Date());
        request.addProperty("DateTimeStamp",currentDateTimeString);//"2012-01-13");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.call(SOAP_ACTION, envelope);
        Log.i("Server", "server data2 "+((Object)envelope.getResponse()));  
    } catch(Exception e) {
        Log.e("Server", "Error on server "+e.getMessage());
    }
}