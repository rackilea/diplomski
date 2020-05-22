public class BackgroundTask extends AsyncTask<Void,Void,Void>{

@Override
protected Void doInBackground(Void... params) {
  //perform network operation and return response
  URL url = new URL("link.to.your.VPS.script");
  //now make a connection
  HttpUrlConnection conn = (HttpUrlConnection) url.openConnection();
  //get response code
  conn.getResponseCode();

  return null;
}

@Override
protected void onPostExecute(Void v){

}
}