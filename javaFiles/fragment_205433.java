for( int i = 0 ; i < jsonArray.length() ; i++ ){
      try {
           JSONObject object = jsonArray.getJSONObject(i);
           if( ! object.isNull("test") ){
                JSONObject j = object.getJSONObject("test");
                System.out.println(j.getString("page"));
                System.out.println(j.getString("ms"));
            }
            if( ! object.isNull("check") ){
                JSONObject j = object.getJSONObject("check");
                System.out.println(j.getString("page"));
                System.out.println(j.getString("ms"));
            }
       } catch (JSONException e) {
              e.printStackTrace();
       }
}