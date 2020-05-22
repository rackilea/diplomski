public class KeyTask extends AsyncTask<Void, Void, String> {

    @Override 
    protected void onPreExecute() { 
        Log.i("onPreExecute", ".onPreExecute() — start");


    } 

    @Override 
    protected String doInBackground(Void ... params) {
        Log.i("TransmissionKeyTask", ".doInBackground() — start");

        }

    @Override
    protected void onPostExecute(String result) {
        Log.i("onPostExecute", ".onPostExecute() — start");
    }       
}