//Start volley:
 RequestQueue queue = Volley.newRequestQueue(this);  // this = context


 final String url = "http://someplace.com/api/xyz"";

 // prepare the Request
 JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
     new Response.Listener<JSONObject>() 
     {
         @Override
         public void onResponse(JSONObject response) {   
             //This is where you setup your UI
             //Remember to dismiss the ProgressDialog
         }
     }, 
     new Response.ErrorListener() 
     {
          @Override
          public void onErrorResponse(VolleyError error) {            
             //Remember to dismiss the ProgressDialog
             Log.d("Error.Response", response);
        }
     }
 );

 // add it to the RequestQueue   
 //Here you should add a ProgressDialog so the user knows to wait
 queue.add(getRequest);