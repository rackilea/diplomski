public class SoapRequest {
private static final String SOAP_ACTION = "xxx";
private static final String METHOD_NAME = "xxx";
private static final String NAMESPACE = "xxx";
private static final String URL = "url of the webservice";

public static SoapObject soap() throws IOException, XmlPullParserException {
    SoapObject request = new SoapObject (NAMESPACE, METHOD_NAME);

/* Here you can add properties to your requests */
    PropertyInfo pi1 = new PropertyInfo();
    pi1.name = "xxx";
    pi1.type = String.class;
    request.addProperty(pi1, "xxx");

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.setOutputSoapObject(request);
    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    androidHttpTransport.debug = true; 
    androidHttpTransport.call(SOAP_ACTION, envelope);
    SoapObject soapResult = (SoapObject) envelope.bodyIn;
    return soapResult;
}