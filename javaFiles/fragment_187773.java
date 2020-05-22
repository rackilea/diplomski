for( int i = 0 ; i < arr1.length() ; i++ ){         
   try {
       JSONObject object = arr1.getJSONObject(i);
       //Check whether it is "test"
       if( ! object.isNull("test") ){
        // do your stuff 
       }
   } catch (JSONException e) {
        e.printStackTrace();
   }
}