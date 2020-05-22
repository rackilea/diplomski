private final List<String> responseList;

      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);

            new HttpGetTask().execute();

            Button shwBtn = (Button) findViewById(R.id.showBtn);

            shwBtn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    AutoCompleteTextView city1 = (AutoCompleteTextView) findViewById(R.id.autoCity);
                    EditText area1 = (EditText) findViewById(R.id.edArea);

                    String aCity = city1.getText().toString().trim();
                    String aArea = area1.getText().toString().trim();

                    //here i have to match acity with all the values in responseList before sending it to next activity

                    for(int i=0; i<responseList.size(); i++) {

                        if(responseList.get(i).equals(aCity)) {
                            Intent myInt = new Intent(getBaseContext(),
                                Map1Activity.class);

                            String city = city1.getText().toString();
                            String area = area1.getText().toString();
                            myInt.putExtra("city", city);
                            myInt.putExtra("area", area);
                            startActivity(myInt);
                        }

                    }
                }
            });

        }

        private class HttpGetTask extends AsyncTask<Void, Void, String> {

            String URL = "xyzz.cities.json?app_id=test";
            AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

            @Override
            protected String doInBackground(Void... params) {
                // http stuff
    return null;
            }

            @Override
            protected void onPostExecute(String result) {
                try {
                    JSONArray json = new JSONArray(result);

    //getting my response(cities)
    Log.v("ResponseCity", result);

                    responseList = new ArrayList<String>();

                    for (int i = 0; i < json.length(); i++) {
                        final JSONObject e = json.getJSONObject(i);

                        String name = e.getString("name");
//Adding all values to a stringList
                        responseList.add(name);

                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<String>(SearchActivity.this,
                                android.R.layout.simple_dropdown_item_1line,
                                responseList);
                        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCity);
                        textView.setAdapter(adapter);

                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (null != mClient)
                    mClient.close();
            }

        }