private Spinner spinner;
private ArrayAdapter<String> adapter;
final List<String> items = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    initializeSpinner();
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            try {
                String updatedItems = "[{\"name\" : \"test1\"}, {\"name\" : \"test2\"}, {\"name\" : \"test2\"}]";
                getItems(new JSONArray(updatedItems));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, 10000);

}


private void initializeSpinner() {
    items.add("initial");

    spinner = (Spinner) findViewById(R.id.spinner);
    adapter = new ArrayAdapter<String>(TestActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
    spinner.setAdapter(adapter);
}

private void getItems(JSONArray j) {
    for (int i = 0; i < j.length(); i++) {
        try {
            //Getting json object
            JSONObject json = j.getJSONObject(i);

            //Adding the name of the student to array list
            items.add(json.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    adapter.notifyDataSetChanged();
}