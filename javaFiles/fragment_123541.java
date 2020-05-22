String url = "https://www.example.com/wp-json/wc/v2/orders?consumer_key=123&consumer_secret=abc";

JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

@Override
public void onResponse(JSONObject response) {
    textViewback.setText("Response: " + response.toString()); 
    }
},  

   new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
    // TODO: Handle error

}
});
// Access the RequestQueue through your singleton class.
MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);