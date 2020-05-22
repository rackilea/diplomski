public class AsyncCallWS extends AsyncTask<String, Void, Object> {
    @Override
    protected Object doInBackground(String... params) {
        Object response = null;
        try {
            response = execute_barcode_webservice(params[0], params[1]);
        } catch (Exception e) {
            // TODO: handle exception
        }   
        return response;
    }

    @Override
    protected void onPostExecute(Object response) {
        if (response != null) {
            // display results in a list or something else
        }
    }