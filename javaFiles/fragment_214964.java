public class MyTask extends AsyncTask<Void,Void,Void> {

    String email1 = editEmail.getText().toString();
    String pass1 = editPass.getText().toString();

    @Override
    protected Void doInBackground(Void... params) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://wswob.somee.com/wobservice.svc/checkLogin/"+email1+"/"+pass1);
        HttpContext localContext = new BasicHttpContext();

        HttpResponse response;

          try {

            response = httpclient.execute(httpGet, localContext);
            HttpEntity entity = response.getEntity();
            status = EntityUtils.toString(entity);



          } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        return null;
    }

    @Override
    protected Void onPostExecute(Void result){
        super.onPostExecute(result);
        //TODO: your code here. check your status and handle from there
    }
}