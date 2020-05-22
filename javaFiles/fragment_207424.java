private class JsonTaskTask extends AsyncTask<Void, Void, Void> {
 private HttpResponse response;
 protected Long doInBackground(Void... params) {
     reponse = getJson();
     return null;
 }

 protected void onPostExecute(Void params) {
     //Show Your Listview
 }

 public  HttpResponse getJson() {
    HttpResponse response = null;
    try {        
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI("https://mysite.com/android/showJson.php"));
            response = client.execute(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   
        return response;
    }
  }