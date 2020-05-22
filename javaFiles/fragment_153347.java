private void makeRequest(String url,final Location location){
    Log.d(TAG, "Url: " + url);
    RequestQueue queue = Volley.newRequestQueue(mContext);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject json = new JSONObject(response);
                        JSONArray results = json.getJSONArray("results");

                        List<LocationContent> list = new ArrayList<>();
                        Log.d(TAG, "no of results: " + results.length());
                        if(results.length() > 0) {
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject googlePlace = results.getJSONObject(i);

                                Double distance = HelperClass.getDistanceFromLatLonInKm(
                                        location.getLatitude(),location.getLongitude(),
                                        googlePlace.getJSONObject("geometry").getJSONObject("location").getDouble("lat")
                                        ,googlePlace.getJSONObject("geometry").getJSONObject("location").getDouble("lng")) / 1000;

                                String distanceBetweenTwoPlace = String.valueOf(distance);
                                String distance_new = distanceBetweenTwoPlace.substring(0, 3);
                                list.add(new LocationContent(googlePlace.getString("name"),
                                        googlePlace.getJSONObject("geometry").getJSONObject("location").getDouble("lat"),
                                        googlePlace.getJSONObject("geometry").getJSONObject("location").getDouble("lng"),Double.valueOf(distance_new)));
                            }
                            //sort the distance
                            Collections.sort(list,new DistanceComparator());
                        }
                        refreshPlaces(list);
                    } catch (JSONException e) {
                        Log.e(TAG, "Error occurred while getting places", e);
                    }
                    Log.d(TAG, "onResponse: " + response.substring(0,250));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    });

    // Add the request to the RequestQueue.
    queue.add(stringRequest);
}


public class DistanceComparator implements Comparator<LocationContent> {
    public int compare(LocationContent L1,LocationContent L2){
        double delta= L1.getDistance() - L2.getDistance();
        if(delta > 0.00001) return 1;
        if(delta < -0.00001) return -1;
        return 0;
    }
}