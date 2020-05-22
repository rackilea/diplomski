public class SendPostRequest extends AsyncTask<String, Void, String> {
    public String sendMessage(String data, String address) {
        [..]
    }   

    @Override
    protected String doInBackground(String... params) {
        return sendMessage(params[0], params[1]);
    }

    @Override
    protected void onPostExecute(String result) {
        Area[] og = gson.fromJson(result, Area[].class);
    }
}