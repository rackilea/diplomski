private class AsyncCallWS extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute");
    }

    @Override
    protected String[] doInBackground(Void... params) {
        Log.i(TAG, "doInBackground");
        String[] data = sendRequest();
        return data;
    }

    @Override
    protected void onPostExecute(String[] result) {
        Log.i(TAG, "onPostExecute");
        if(result != null && result.length > 0){
             textResult.setText( results[0]);
        }
    }

}


private String[] sendRequest(){
    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


    //SoapObject
    request.addProperty("@CountryName", "SPAIN");
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.setOutputSoapObject(request);


    androidHttpTransport = new HttpTransportSE(URL);
    try
    {
        androidHttpTransport.call(SOAP_ACTION, envelope);
        resultsRequestSOAP =  envelope.getResponse();
        String[] results = (String[])  resultsRequestSOAP;
    }
    catch (Exception aE)
    {
        aE.printStackTrace ();
    }
}