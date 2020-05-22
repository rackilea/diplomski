HeaderAwareJsonRequest req = new HeaderAwareJsonRequest( 
   Request.Method.GET, 
   AppConfig.URL_LOGIN, 
   new Response.Listener<Pair<JSONObject,Map>>() {
     @Override
     public void onResponse(Pair<JSONObject,Map> response) {
       JSONObject jObj = response.first;
       Map headers = response.second;
       String someHeader = headers.get( "aaaaa" );
       ...
     }
   }, 
   new Response.ErrorListener() {...} 
);