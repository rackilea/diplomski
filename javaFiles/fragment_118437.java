StringRequest stringObjectRequest = new StringRequest(httpMethod, url, new Listener<String>() {
           @Override
           public void onResponse(String response) {

           }
       }, new ErrorListener() {

           @Override
           public void onErrorResponse(VolleyError error) {
               if(error != null && error.getMessage() != null)
               {
                   Log.e("Response error", error.getMessage());
               }
           }
       }
       )
       {
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               return params;
           }
           @Override
           public Map<String, String> getHeaders() throws AuthFailureError {
               return super.getHeaders();
           }
       };