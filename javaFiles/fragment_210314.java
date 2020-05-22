public class ListSuggestions extends AsyncTask<Void, Void, Void> {

    @Override
    protected Boolean doInBackground(String... params) {
        // do something
        return true;
    }

    @Override
    protected void onPostExecute(String result) {
        // The results of the above method
        // Processing the results here

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
             this,
             android.R.layout.simple_list_item_1,
             list);

        listv.setAdapter(arrayAdapter);

    }

}