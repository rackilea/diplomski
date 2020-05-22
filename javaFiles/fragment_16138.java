userid=new PropertyInfo();
password=new PropertyInfo();

request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);

envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.dotNet = true;
envelope.setOutputSoapObject(request);
httpTransport = new HttpTransportSE(SOAP_ADDRESS);

userid.setName("userid");
userid.setValue("youruserid");
userid.setType(String.class);
password.setName("password");
password.setValue("Yourpassword");
password.setType(String.class);

request.addProperty(userid);
request.addProperty(password);

httpTransport.call(SOAP_ACTION, envelope); 
response = (SoapPrimitive) envelope.getResponse();
resp=response.toString();