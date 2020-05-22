JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
            URL, null, new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {
            //Do something with response
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            //Do something with error
        }
    });

    //Put the actual request on the queue
    MyApp.getInstance().addToRequestQueue(req);