public class AsynTaskActivity extends AsyncTask<HashMap<String, Integer>, String, Object> {

    @Override
    protected Object doInBackground(HashMap<String, Integer>... hashMaps) {
        // non-ui thread
        HashMap<String, Integer> maps = hashMaps[0];
        Set set = maps.entrySet();
        for (Object aSet : set) {
            Map.Entry entry = (Map.Entry) aSet;
            publishProgress(entry.getKey().toString()); // onProgressUpdate callback
        }
        return null; // onPostExecute callback
    }

    @Override
    protected void onProgressUpdate(String... progress) {
        // ui thread
        receiveBarcode(progress);
    }

    @Override
    protected void onPostExecute(Long result) {
        // ui thread
    }
}