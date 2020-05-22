public class LoginAcitivity extends Activity {

    private String METHOD_NAME = "";
    // our webservice method name
    private String NAMESPACE = "http://ws.com";
    // Here package name in webservice with reverse order.
    private String SOAP_ACTION = NAMESPACE + METHOD_NAME;
    // NAMESPACE + method name
    // private static final String URL =
    private static final String URL = "http://my-ip:8080/ConverterWebSrvice/services/Converter";

    // you must use ipaddress here, don’t use Hostname or localhost

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access);

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AccessWebServiceTask task = new AccessWebServiceTask();
                task.execute();
            }
        });
    }

    public void ws() {
        String name = "Dan";

        METHOD_NAME = "sayHello";
        try {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("name", name);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            Object result = envelope.getResponse();
            ((TextView) findViewById(R.id.textView1)).setText(name
                + " Longitude is : " + result.toString());

        } catch (Exception E) {
            E.printStackTrace();
            ((TextView) findViewById(R.id.textView1)).setText("ERROR:"
                + E.getClass().getName() + ":" + E.getMessage());
        }
    }

    class AccessWebServiceTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ws();
            return null;
        }

    }

}