public class SendMailTask extends AsyncTask <Object1, Object2, Object3> {

    @Override
    protected Object doInBackground(Object1... args) {
    ...    

       //publishProgress calls "onPublishProgress" method
       //e.g. publishProgress("email sent.");  
       publishProgress(object2); 

       //last line returns to "onPostExecute" method
       //e.g. return null;
       return object3; 
    }

    @Override
    public void onProgressUpdate(Object2... values) {
    ...

    }

    @Override
    public void onPostExecute(Object3 result) {
    ...
    } 
}