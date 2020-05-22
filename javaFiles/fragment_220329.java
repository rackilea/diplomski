public void getLocationFromAddress(String address) {
    String url = "https://maps.googleapis.com/maps/api/geocode/json?address="
            + Uri.encode(address) + "&sensor=true&key=API_KEY";
    RequestQueue queue = Volley.newRequestQueue(this);
    JsonObjectRequest stateReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            JSONObject location;
            try {
                // Get JSON Array called "results" and then get the 0th
                // complete object as JSON
                location = response.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                // Get the value of the attribute whose name is
                // "formatted_string"
                if (location.getDouble("lat") != 0 && location.getDouble("lng") != 0) {
                    LatLng latLng = new LatLng(location.getDouble("lat"), location.getDouble("lng"));

                    //Do what you want
                }
            } catch (JSONException e1) {
                e1.printStackTrace();

            }
        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("Error.Response", error.toString());
        }
    });
    // add it to the queue
    queue.add(stateReq);

}