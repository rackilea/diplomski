private class MyTask extends AsyncTask<Void, Void, Void> {

//you can change the Type Void, Void, Void here to something which you want 
//First Void belongs to doInBackground(Void... avoid)
//Second Void belongs to onProgressUpdate(Void... progress) 
//Third Void belongs to onPostExecute(Void result)
// you may change these as you fit, 
//when you want to start this class with your argument you can do something like this. 
//new MyTask().execute("your argument to doInBackground");


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
    // this is the method where you provide your implementation for doing a task off the main UI thread.
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    // in this callback you are back in the main UI thread to make changes to UI depending on your response 
    }
}