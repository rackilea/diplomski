JsonObjectRequest jsObjRequest = new JsonObjectRequest
        (Request.Method.GET, "http://api.themoviedb.org/3/movie/550?api_key={MY_API_KEY}", null, new Response.Listener<JSONObject>() {

    @Override
    public void onResponse(JSONObject response) {
        System.out("title: " + response.getString("original_title"));
    }
}, new Response.ErrorListener() {

    @Override
    public void onErrorResponse(VolleyError error) {
        // TODO Auto-generated method stub

    }
});