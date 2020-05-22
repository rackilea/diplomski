private class LongNetworkOperation extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        SoapObject so = new SoapObject(namespace, methodName);
        so.addProperty("name", "Arjun");
        SoapSerializationEnvelope sse = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        sse.setOutputSoapObject(so);
        HttpTransportSE hse = new HttpTransportSE(url);

        try {
            hse.call(action, sse);
            SoapPrimitive primitive = (SoapPrimitive)sse.getResponse();
            Toast.makeText(getApplicationContext(),primitive.toString() , Toast.LENGTH_SHORT);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}