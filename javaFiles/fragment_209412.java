JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject response) {

        try {
            JSONArray jsonArray = response.getJSONArray("listCar");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                CarClass car = new CarClass();
                car.setTitle(jsonObject.getString("adTitle"));
                car.setDate(jsonObject.getString("adDate"));

                // Left of the implementation

            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley", error.toString());
    }
});

RequestQueue requestQueue = Volley.newRequestQueue(this);
requestQueue.add(jsonObjectRequest);