@Override
 public  ArrayList<String> doInBackground(String... arg0) {

    ArrayList<String> values = new ArrayList<String>();
     try {

         // instantiate our json parser
         JsonParser jParser = new JsonParser();

         // get json string from url
         JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);

         // get the array of users
         dataJsonArr = json.getJSONArray("response");

         // loop through all users
         for (int i = 1; i < dataJsonArr.length(); i++) {

             JSONObject c = dataJsonArr.getJSONObject(i);
             String text = c.getString("text");
             values.add(text); 
         }
     }  
     catch (JSONException e) {
         e.printStackTrace();
     }

     return values;
 }