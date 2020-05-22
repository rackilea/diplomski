final static String NAMESPACE = "urn:sap-com:document:sap:soap:functions:mc-style";
    final static String METHOD_NAME = "ZmblHucremalzemelistesi";
    final static String SOAP_ACTION = "";
    final static String URL = "http://xxx.xxx.xxx.xxx:1080/sap/bc/srt/wsdl/bndg_4F969242EA785040E10080008D0B0B03/wsdl11/allinone/ws_policy/document?sap-client=010";

    private static final String USERNAME = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";

    private void testWS() {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("ILgort", "H12");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        AuthTransportSE androidHttpTransport = new AuthTransportSE(URL, USERNAME, PASSWORD);
        androidHttpTransport.debug = true;

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject) envelope.getResponse();
            // if it did not work, try this:
            // SoapObject response = (SoapObject) envelope.bodyIn;

            tv.setText(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }