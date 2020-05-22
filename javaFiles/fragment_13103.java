private class httpGet extends AsyncTask<ParamForDoInBackground, ParamForOnProgressUpdate, ParamForOnPostExecute> {
     protected Long doInBackground(ParamForDoInBackground... urls) {
        // do the request here
     }

     protected void onProgressUpdate(ParamForOnProgressUpdate progress) {
        // if you need to show any progress of the 
        // request from doInBackground
     }

     protected void onPostExecute(ParamForOnPostExecute result) {
        // this method will run when doInBackground
        // is done executing
     }
}