}, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.toString());
                }
        }) {  // Add this

        @Override           
        public Map<String, String> getHeaders() throws AuthFailureError {
               Map<String, String> headers = new HashMap<String, String>();
               headers.put("xxx", xxx);
               return headers;
            }
       };