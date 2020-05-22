private class HttpAsyncTask extends AsyncTask<String, Void, String> {

@Override
protected String doInBackground(String... params) {

    return GET();

}
// onPostExecute displays the results of the AsyncTask.
@Override
protected void onPostExecute(String result) {
    //   Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
    //  etResponse.setText(result);

    if (result=="failed"){
       sesionFail();
    }
    else{
        sesionIn();
    }


}
}
public String GET() {

String url = "http://"+ippref+":8080/WSAppInventario/webresources/inventario.users/Login/"+usuario_ws+"/"+pass_ws+"";
String result = "";
BufferedReader inStream = null;
try {
    HttpClient httpClient = new DefaultHttpClient();
    HttpGet httpRequest = new HttpGet(url);
    HttpResponse response = httpClient.execute(httpRequest);
    inStream = new BufferedReader(
            new InputStreamReader(
                    response.getEntity().getContent()));

    StringBuffer buffer = new StringBuffer();
    String line = "";
    //String NL = System.getProperty("line.separator");
    while ((line = inStream.readLine()) != null) {
        buffer.append(line);
    }
    inStream.close();
    result = buffer.toString();
    respuesta_ws = Integer.valueOf(result);
} catch (Exception e) {

    e.printStackTrace();
    return "failed";
}
return result;
}