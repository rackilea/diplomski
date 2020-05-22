public class SimpleAsyncTask extends AsyncTask<String, String, String>{

private OnTaskCompleteListener listener;

public SimpleAsyncTask(OnTaskCompleteListener listener) {
    this.listener = listener;
}

    protected String doInBackground(String... uri) {
        //working code
    }


    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        ...//Convert the response to list and call your listener
listener.onTaskComplete(list);
        // return list //expected value;// no need of it now.
    }
}