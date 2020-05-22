public void updateJSONdata() {
        Bundle b = getIntent().getExtras();
        String searchquery = b.getString("searchquery");

        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("searchquery", searchquery));

        Log.d("request!", "starting");

        //Posting user data to script
        JSONObject json = jsonParser.makeHttpRequest(
                SEARCH_URL, "POST", params);

        // full json response
        Log.d("Search attempt", json.toString());

        try {

            mResultList = new ArrayList<HashMap<String, String>>();

            mResults = json.getJSONArray(TAG_POSTS);

            // JSONArray mComments = new JSONArray(TAG_POSTS);

            // looping through all posts according to the json object returned
            for (int i = 0; i < mResults.length(); i++) {
                JSONArray innerArray = mResults.optJSONArray(i);
                for (int j = 0; j < innerArray.length(); j++) {
                    JSONObject c = innerArray.getJSONObject(j);
                    //gets the content of each tag
                    String title = c.getString(TAG_TITLE);
                    String address = c.getString(TAG_ADDRESS);
                    String brand = c.getString(TAG_BRAND);
                    String company = c.getString(TAG_COMPANY);
                    String id = c.getString(TAG_ID);
                    //so our JSON data is up to date same with our array list

                    // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put(TAG_TITLE, title);
                    map.put(TAG_ADDRESS, address);
                    map.put(TAG_BRAND, brand);
                    map.put(TAG_COMPANY, company);
                    map.put(TAG_ID, id);

                    mResultList.add(map);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts the parsed data into our listview
     */

    private void updateList() {
         //if you choose the other method
        // final ArrayList<HashMap<String, String>> mResultList = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("arraylist");
        // System.out.println("...serialized data.."+mResultList);

        Bundle b = getIntent().getExtras();
        final String searchquery = b.getString("searchquery");

        ListAdapter adapter = new SimpleAdapter(this, mResultList,
                R.layout.single_result, new String[]{TAG_TITLE, TAG_ADDRESS, TAG_BRAND,
                TAG_COMPANY, TAG_ID}, new int[]{R.id.outlet, R.id.address, R.id.brand,
                R.id.company});
        setListAdapter(adapter);

        listView.setSelector(R.drawable.listselector);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                // ListView Clicked item value
                                                Map<String, String> map = (Map<String, String>) mResultList.get(position);
                                                String record_id = map.get(TAG_ID);
                                                Intent r = new Intent(Results.this, Record.class);
                                                r.putExtra("key", record_id);
                                                r.putExtra("searchquery", searchquery);
                                                startActivity(r);
                                            }

                                        }
        );
    }