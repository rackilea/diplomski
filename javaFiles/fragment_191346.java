private class MyAsyncTask extends AsyncTask<String, Void, String> {

 private String username="";
 private String password="";

 public MyAsyncTask(String user, String pass)
 {
    this.username = user;
    this.password = pass;
 }

 protected void onPreExecute() {

 }

 protected Bitmap doInBackground(String... strings) {
     // Some long-running task like downloading an image.
     // No UI related work here.. or else it will crash

 }



 protected void onPostExecute(Bitmap result) {
     // This method is executed in the UIThread
     // with access to the result of the long running task

 }
}