private static final String NAMESPACE = "http://www.kltro.com";
private static final String METHODNAME = "getUser";
private static final String WSDL = "http://ap.kashkan.org:55555/tro/ws/kltro";
private static final String SOAP_ACTION = NAMESPACE + "#kltro:" + METHODNAME ;

private static String TAG = "soap";

public static String callWebservice() {
    String responseDump = "";
    try {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
        request.addProperty("login", login);
        request.addProperty("pass", password);
        request.addProperty("androidID", androidID);
        request.addProperty("ver", version);

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