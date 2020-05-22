public static Document GetWebServiceData(String WebServiceMethod, List<Parameter> Params) {
    try { 
        SoapObject request = new SoapObject(NameSpace, WebServiceMethod);         
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;

        for(Parameter param : Params)
            request.addProperty(param.getParameterName(), param.getParameterValue());

        envelope.setOutputSoapObject(request);
        androidHttpTransport.call(NameSpace + "/" + WebServiceMethod, envelope); 

        SoapPrimitive responseData = (SoapPrimitive) envelope.getResponse();
        if (responseData != null)
        {
            //get the factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            InputSource is = new InputSource(new StringReader(responseData.toString()));
            return db.parse(is);
        }
        else
            return null;
    }
    catch (Exception e)
    {
        Errors.LogError(e);
        return null;
    }
}