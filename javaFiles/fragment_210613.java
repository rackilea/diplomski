while ((csvdata= br.readLine()) != null) {
   JSONObject output= new JSONObject(csvdata);
   JSONArray docs = output.getJSONArray("value");

   for(int i=0; i<docs.length();i++){
       JSONObject geo_pos =  (JSONObject)(docs.getJSONObject(i).getJSONObject("geo_position"));
       docs.getJSONObject(i).put("latitude", geo_pos.get("latitude"));
       docs.getJSONObject(i).put("longitude", geo_pos.get("longitude"));
       docs.getJSONObject(i).remove("geo_position");
   }       

   String csv = CDL.toString(docs);
   FileUtils.writeStringToFile(file, csv);
 }