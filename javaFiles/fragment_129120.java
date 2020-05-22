protected String doInBackground(String... args) {
                List<NameValuePair> params = new ArrayList<NameValuePair>();

                // getting JSON string from URL
                String json = jsonParser.makeHttpRequest(EventsActivity.URL_CATEGORIES, "GET",
                        params);

                try {               
                    arrayAngels = new JSONArray(json).getJSONObject(0).getJSONArray("angelList");

                    if (arrayAngels != null) {

                        // looping through All albums
                        for (int i = 0; i < arrayAngels.length(); i++) {
                            JSONObject c = arrayAngels.getJSONObject(i);

                            // Storing each json item values in variable
                            String name = c.getString(ANGEL_NAME);

                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            map.put(ANGEL_NAME, name);                          

                            // adding HashList to ArrayList
                            angelsList.add(map);
                        }
                    }else{
                        Log.d("Angels: ", "null");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }