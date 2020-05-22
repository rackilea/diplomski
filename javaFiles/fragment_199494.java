private ListView mTripList;
public ArrayList<TripItem> tripItems;
private JSONArray unclaimedTrips;
private TripSelectAdapter adapter;



public void getTrips() {

        JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray> () {  

        @Override
        public void onResponse(JSONArray response) {

            // Public Array
            unclaimedTrips = response;

            tripItems = new ArrayList<TripItem>();


            // Optional if you want to manipulate the data in some way
            if (unclaimedTrips != null) {

                for (int i = 0; i < unclaimedTrips.length(); i++) {

                    try {
                        JSONObject item = unclaimedTrips.getJSONObject(i);

                        int tripID = item.getInt("trip_id");
                        int claimID = item.getInt("claim_id");
                        String payrollCode = item.getString("payroll_code");
                        String tripDate = item.getString("trip_date");
                        String tripPurpose = item.getString("trip_purpose");

                        TripItem tripItem = new TripItem(tripID, claimID, payrollCode, tripDate, tripPurpose);

                        tripItems.add(tripItem);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                refreshData();
            }

        }


    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            unclaimedTrips = null;
            refreshData();

        }
    }) {

       @Override
       public Map<String, String> getHeaders() throws AuthFailureError {
           HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("Content-Type", "application/json");
           return headers;
       };
    };


    // add the request object to the queue to be executed
    MyApplication.getInstance().addToRequestQueue(req);
}


public void refreshData() {

    if (tripItems.isEmpty()) {
        mEmptyList.setVisibility(android.view.View.VISIBLE);
    } else {
        mEmptyList.setVisibility(android.view.View.GONE);                   
    }

    adapter = new TripSelectAdapter(this, thisContext, tripItems);
    mTripList.setAdapter(adapter);
}