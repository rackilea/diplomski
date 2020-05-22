public class ViewNames extends Activity {

    ListView listView;
    List<String> result;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewnames);
        listView = (ListView) findViewById(R.id.listView);
        result = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ViewNames.this, android.R.layout.simple_list_item_1,result);
        listView.setAdapter(adapter);

        (new ViewNamesJSON()).execute();
    }

    public class ViewNamesJSON extends AsyncTask<String, String, String> {

        // Other methods go here. They work fine.

        @Override
        protected void onPostExecute(String s) {
            List<String> namesList = new ArrayList<String>();
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.optJSONArray("names");

                for(int i=0; i < jsonArray.length(); i++){
                    JSONObject ones = jsonArray.getJSONObject(i);
                    String names = ones.optString("names");
                    namesList.add(names);
                }
                result.clear();
                result.addAll(namesList);
                adapter.notifyDataSetChanged();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}