public class JSONRequestService {

    private final Context mContext;  // TODO: Make constructor 

    final Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Error", error.getMessage());
        };

    // passthough a callback instead of returning 
    public void postRequest(Response.Listener<JSONObject> listener) {
        CustomRequest jsonObjectRequest = new CustomRequest(Request.Method.GET, this.url, requestParameters, listener, errorListener);

        // TODO: Add to request queue 

    } 
}