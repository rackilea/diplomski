public class CallSoap {
public static String NAMESPACE = "http://127.0.0.1:80/";
public static String URL = "http://127.0.0.1:80/service.asmx?WSDL";
public static Customer[] customers;
public static int AddCustomer(Customer[] customers) {
    String MethodName = "AddCustomer";
    SoapObject soapAddCustomer = new SoapObject(NAMESPACE, MethodName);
    //customers Parameter
    SoapObject soapDetails = new SoapObject(NAMESPACE, "customers");
    SoapObject soapDetail[] = new SoapObject[customers.length];

    for (int i=0;i<customers.length;i++){
        soapDetail[i]= new SoapObject(NAMESPACE, "Customer");
        soapDetail[i].addProperty("Customer_ID", customers[i].Customer_ID);
        soapDetail[i].addProperty("Customer_Name", customers[i].Customer_Name);
        soapDetail[i].addProperty("Customer_Family", customers[i].Customer_Family);

    }

    soapAddRequest.addSoapObject(soapDetails);
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope( SoapEnvelope.VER11);
    envelope.dotNet = true;
    envelope.setOutputSoapObject(soapAddRequest);
    envelope.addMapping(NAMESPACE, "Customer", new Customer().getClass());
    HttpTransportSE HttpTransportSE = new HttpTransportSE(URL);
    try {
        HttpTransportSE.call(NAMESPACE + MethodName, envelope);
        String result = envelope.getResponse().toString();
        return Integer.parseInt(result);
    } catch (Exception e) {
        e.printStackTrace();
        return 0;

        }
}