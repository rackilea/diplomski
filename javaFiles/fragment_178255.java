@Override
    protected String doInBackground(String... args) {
        // TODO Auto-generated method stub
        // Check for success tag
        int success;
        String searchquery = searchterm.getText().toString();

        try {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("searchquery", searchquery));

            Log.d("request!", "starting");

            //Posting user data to script
            JSONObject json = jsonParser.makeHttpRequest(
                    SEARCH_URL, "POST", params);

            // full json response
            Log.d("Search attempt", json.toString());

            // json success element
            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                Log.d("Successful Search!", json.toString());
                //save search data


                mCommentList = new ArrayList<HashMap<String, String>>();

                mComments = json.getJSONArray(TAG_POSTS);

               // JSONArray mComments = new JSONArray(TAG_POSTS);

                    // looping through all posts according to the json object returned
                for (int i = 0; i < mComments.length(); i++) {
                    JSONArray innerArray = mComments.optJSONArray(i);
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

                        mCommentList.add(map);
                    }
                }
                Intent r = new Intent(Search.this, Results.class);
                //either
                //r.putExtra("arraylist", mCommentList);
                // startActivityForResult(r, 5000);
               //or
                r.putExtra("searchquery", searchquery);
                startActivity(r);

                return json.getString(TAG_MESSAGE);
            }else{
                Log.d("Invalid Search!", json.toString());

                return json.getString(TAG_MESSAGE);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }