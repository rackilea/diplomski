public static String registerStudentClass(Student stud) {
  soapAction="http://auth.ws.df.com/RegisterStudent";
  methodName="RegisterStudent";
  String resTxt = null;

  //new change
  PropertyInfo pi = new PropertyInfo();
  pi.setName("stud");
  pi.setValue(stud);
  pi.setType(stud.getClass());

  SoapObject request = new SoapObject(NAMESPACE, methodName);
  request.addProperty(pi);

  SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
  SoapEnvelope.VER11);
  envelope.setOutputSoapObject(request);//new change
  envelope.addMapping(NAMESPACE, "Student", new Student().getClass());
  HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
  System.out.println("androidHttpTransport envelope");

  try{
      androidHttpTransport.call(soapAction, envelope);
      SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
      resTxt = response.toString();
   }catch(Exception e){
      e.printStackTrace();
      resTxt = "Error occured\n"+e;
  }

  return resTxt;
}