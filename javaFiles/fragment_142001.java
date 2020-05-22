btnShowDetails.setOnClickListener(new OnClickListener() {

  @Override
  public void onClick(View v) {
   LoadDetailsTask task = new LoadDetailsTask();
  task.execute("ID01");
 }
 });


class LoadDetailsTask extends AsyncTask<string simpleobject="" void=""> {

  private final String NAMESPACE = "http://service.blog.anjula.com/";
  private final String URL = "http://112.135.137.22:8080/BlogWebService/BlogWebService?WSDL";
  private final String SOAP_ACTION = "http://service.blog.anjula.com/getDetails";
  private final String METHOD_NAME = "getDetails";

  SimpleObject result = new SimpleObject();

  @Override
  protected SimpleObject doInBackground(String... addId) {

   SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

   PropertyInfo idListPropety = new PropertyInfo();

   idListPropety.setName("id");
   idListPropety.setValue(addId[0]);
   idListPropety.setType(addId[0].getClass());
   request.addProperty(idListPropety);

   SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
     SoapEnvelope.VER11);

   // envelope.dotNet = true;
   envelope.setOutputSoapObject(request);

   envelope.addMapping(NAMESPACE, "SimpleObject",
     new SimpleObject().getClass());

   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

   try {
    androidHttpTransport.debug = true;
    androidHttpTransport.call(SOAP_ACTION, envelope);
    SoapObject response = (SoapObject) envelope.getResponse();

    result.setId(response.getProperty("id").toString());
    result.setName(response.getProperty("name").toString());
    result.setAddress(response.getProperty("address").toString());

    return result;

   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (XmlPullParserException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }

   return null;

  }

  @Override
  protected void onPostExecute(SimpleObject result) {
   // TODO Auto-generated method stub
   if (result != null)
    textViewResult.setText("Id: " + result.getId() + "\nName: "
      + result.getName() + "\nAddress: "
      + result.getAddress());
  }

 }