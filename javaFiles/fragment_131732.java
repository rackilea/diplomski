JSONArray nameservice = convertJSON.getJSONArray("nameservice");
for (int i=0; i<nameservice.length(); i++) {
   JSONObject details = nameservice.getJSONObject(i);
   // process the object here, eg
   System.out.println("ID is " + details.get("id"));
   System.out.println("Name is " + details.get("name"));
}