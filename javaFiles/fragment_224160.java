public List call(String soapAction, SoapSerializationEnvelope envelope, List headers)
     throws IOException, XmlPullParserException {

             if (soapAction == null)
                     soapAction = "\"\"";

             byte[] requestData = createRequestData(envelope);

             requestDump = debug ? new String(requestData) : null;
             responseDump = null;

             connection = getServiceConnection();

             connection.setRequestProperty("User-Agent", "kSOAP/2.0");
//           connection.setRequestProperty("SOAPAction", soapAction);
//           connection.setRequestProperty("Content-Type", "text/xml");
             connection.setRequestProperty("Content-Type", "application/soap+xml");
             connection.setRequestProperty("Connection", "close");
             connection.setRequestProperty("Content-Length", "" + requestData.length);