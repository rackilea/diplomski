RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
StringRequest stringRequest = new StringRequest(Request.Method.GET, WS_GET_CITY, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        progressbar.setVisibility(View.GONE);

        try {
            jsonObject = new JSONObject(response);
            jsonArray = jsonObject.getJSONArray("getCity");
            ac_srccity = (AutoCompleteTextView) findViewById(R.id.ac_srccity);
            ArrayAdapter<String> adapterSrc = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, copyJSONArrayToArrayList(jsonArray));
            ac_srccity.setAdapter(adapterSrc);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
        progressbar.setVisibility(View.GONE);
    }
});

queue.add(stringRequest);