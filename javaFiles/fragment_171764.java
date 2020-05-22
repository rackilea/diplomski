private void postTestAnswerResult(String id, String answerResult) {
  StringRequest req = null;
  requestQueue = Volley.newRequestQueue(this);

  final String baseURL = "http://blah.blah.com/api/answer/";
  String URL = baseURL + id;



  req = new StringRequest(Request.Method.PUT, URL,

    new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            VolleyLog.v("Response:%n %s", response.toString());
        }
    },
    new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            try {
                String responseBody = new String(
                        volleyError.networkResponse.data, "utf-8");
                JSONObject jsonObject = new JSONObject(responseBody);
            } catch (JSONException e) {
                // Handle a malformed json response
            } catch (UnsupportedEncodingException error) {

            }
        }
    }
) {
  @Override
  protected Map<String, String> getParams()
  { 
    HashMap<String, String> params = new HashMap<String, String>();
    // params.put("Content-Type","application/x-www-form-urlencoded"); This shouldn't be here. This is a HTTP header. If you want to specify header you should also override getHeaders. 
    params.put("type", answerResult);  

    return params;
  }

};

 requestQueue.add(req);