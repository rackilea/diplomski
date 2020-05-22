public class PerformNetworkTasks extends AsyncTask<String, String, List<String>/*resultParam*/> {

    @Override
    protected List<String>/*will same as result parma*/ doInBackground(String... params) {
        return null;/*now you can return list of string*/
    }

    @Override
    protected void onPostExecute(List<String>/*finally receive result*/ result) {
        super.onPostExecute(result);
    }
}