StringRequest postReq = new StringRequest(Request.Method.POST, "http://httpbin.org/post", new Response.Listener<String>() 
{

    @Override
    public void onResponse(String response) {
        tv.setText(response); // We set the response data in the TextView
        progressDialog.dismiss();
    }
}, 

new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(“Volly Error”,”Error: ”+error.getLocalizedMessage());
            progressDialog.dismiss();
        }
});