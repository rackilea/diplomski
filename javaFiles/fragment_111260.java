import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.R.array;
import android.util.Log;

public class WebService {
    //Namespace of the Webservice - can be found in WSDL
    private static String NAMESPACE = "http://tempuri.org/";

    //Webservice URL - WSDL File location   
    private static String URL = "webservice path";

    //Make sure you changed IP address
    //SOAP Action URI again Namespace + Web method name
    private static String SOAP_ACTION = "http://tempuri.org/";

    public static String invokeCategory( String webMethName, String compId) {
        String loginStatus = "";

        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);

        // Property which holds input parameters
        PropertyInfo compidPI = new PropertyInfo();

        // Set Username
        compidPI.setName("companyid");

        // Set Value
        compidPI.setValue(compId);

        // Set dataType
        compidPI.setType(String.class);

        // Add the property to request object
        request.addProperty(compidPI);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);
        envelope.dotNet = true;

        // Set output SOAP object
        envelope.setOutputSoapObject(request);

        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);

            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            // Assign it to  boolean variable variable
            loginStatus = response.toString();

        } catch (Exception e) {
            //Assign Error Status true in static variable 'errored'
            Login.errored = true;
            e.printStackTrace();
        } 

        //Return booleam to calling object
        return loginStatus;
    } 
}