private void callWebservice() {
    String tag_json_obj = "GetItem";
    String url = String.format("http://digitalbox.getsandbox.com/item");
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            try {
                new SaveData().execute(response.getJSONArray("Sections"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d("Settings", "Error: " + error.getMessage());
        }
    }) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            return headers;
        }
    };
    NetworkController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj);
}