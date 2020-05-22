search.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            final JSONObject json = null;

            String selectedCategory = searchCategory.getSelectedItem().toString();
            String selectedLocation = searchLocation.getSelectedItem().toString();

            //define params outside AsyncTask
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("location", selectedLocation));
            params.add(new BasicNameValuePair("category", selectedCategory));
            // you can either use as AsyncTask<String,String,String> or AsyncTask()
            new AsyncTask(){
                @Override
                protected void onPreExecute() {

                    pDialog = new SweetAlertDialog(Search.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog.setTitleText("Loading product details...Please wait...");
                    pDialog.setCancelable(true);
                    pDialog.show();
                }

                @Override
                protected Object doInBackground(Object[] params) {
                   // now you can put params as parameter in json
                    json = jsonParser2.makeHttpRequest(url_search_items, "GET", params);

                    Log.d("Search Details", json.toString());
                    return json;
                    // returned object will be directly send to onPostExecute()
                }

                @Override
                protected void onPostExecute(Object o) {
                    // cast returned object from doInBackground() to JSONObject
                    json = (JSONObject)o;
                    try {
                        // Checking for SUCCESS TAG
                        int success = json.getInt(TAG_SUCCESS);

                        if (success == 1) {
                            // products found
                            // Getting Array of Products
                            products = json.getJSONArray(TAG_PRODUCTS);

                            // looping through All Products
                            for (int i = 0; i < products.length(); i++) {
                                JSONObject c = products.getJSONObject(i);

                                // Storing each json item in variable
                                String id = c.getString(TAG_PID);
                                String iname = c.getString(TAG_NAME);
                                String price = c.getString(TAG_PRICE);
                                String path = c.getString(TAG_PATH);
                                String posted_at = c.getString(TAG_TIME);

                                // creating new HashMap
                                HashMap<String, String> map = new HashMap<String, String>();

                                // adding each child node to HashMap key => value
                                map.put(TAG_PID, id);
                                map.put(TAG_NAME, iname);
                                map.put(TAG_PRICE, price);
                                map.put(TAG_PATH, path);
                                map.put(TAG_TIME, posted_at);
                                // adding HashList to ArrayList
                                productsList.add(map);
                            }
                        } else {
                            // no products found
                            // Launch Add New product Activity
                            // you can put SEARCH.this instead of getApplicationContext()
                            Intent i = new Intent(SEARCH.this,
                                    MainActivity.class);
                            // Closing all previous activities
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    pDialog.dismiss();

                    runOnUiThread(new Runnable() {
                        public void run() {

                            adapter=new LazyAdapter(Search.this, productsList);
                            list.setAdapter(adapter);

                        }
                    });
                }
            }.execute();
        }
    });