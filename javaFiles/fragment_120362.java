Vector<SoapObject> vectorOfSoapObject = (Vector<SoapObject>)envelop.getResponse();
for (SoapObject soapObject : vectorOfSoapObject) {
   // put all properties into  DataPlusID  object
   DataPlusID  dataPlusIDObj = new DataPlusID();
   dataPlusIDObj.setData(soapObject.getPropertyAsString("data"));
}