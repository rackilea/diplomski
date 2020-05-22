ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressbar);
    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
    ArrayList<String> answersStringArray= new ArrayList<String>(); // define string array

progressbar.setVisibility(View.VISIBLE);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(getApplicationContext(), "Response", Toast.LENGTH_SHORT).show();
            progressbar.setVisibility(View.GONE);

            try {
                JJSONObject jsonObject = new JSONObject(response); //cast responce to jsonObject
                Iterator<?> keys = jsonObject.keys(); // get the keys of the jsonObject
                while( keys.hasNext() ) {//iterrate over them
                    String key = (String)keys.next();
                    answersStringArray.add(jsonObject.optString(key));}// add the string to our array of stings


          } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Catch", Toast.LENGTH_LONG).show();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            progressbar.setVisibility(View.GONE);
        }
    });

    queue.add(stringRequest);