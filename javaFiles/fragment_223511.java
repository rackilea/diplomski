protected Model doInBackground(String... params) {
   try{
        URL url = new URL (strUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.connect();

        //get response from server
        BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String value = bf.readLine();
        String json = value;
        JSONObject parentObject = new JSONObject(json);
        JSONArray parentArray = parentObject.getJSONArray("Data");
        JSONObject finalObject = parentArray.getJSONObject(parentArray.length()-1);

        String name = finalObject.getString("NAME");
        String username = finalObject.getString("USERNAME");
        String age = finalObject.getString("AGE");

        return new Model(username,name,age);

       }catch(Exception e){
            System.out.println(e);
       }
 }