...
    public JSONObject getJSONfromURL (String url){
        //HTTP call
        try{
            URLConnection connection = new URL(url).openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()), 2048 * 16);
            StringBuffer builder = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
              builder.append(line).append("\n");
            }
            String blah = builder.toString();

            //Parsing string into JSONArray
            JSONArray data = new JSONArray(new String(blah));


            for(int i=0; i < data.length(); i++)
            {
                 object = data.getJSONObject(i);
                 String id = object.getString("id"); 
                 String value = object.getString("name"); 
                 Log.d("Item name: ", value);
            }




            } catch(Exception e){
                Log.e("Http Error","Error in http connection " + e.toString());

            }


        return object;
    }


..