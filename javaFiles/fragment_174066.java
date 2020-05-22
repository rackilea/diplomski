String uri="http://data.someSite.api/path/to/the/file.json";               
   HttpGet get = new HttpGet(uri);
   HttpClient client = new DefaultHttpClient();
   HttpResponse response = client.execute(get);
   BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
   StringBuilder builder=new StringBuilder();
  for(String line=null;(line = reader.readLine()) != null;){
  builder.append(line).append("\n");
}
  JSONTokener jsonTokener=new JSONTokener(builder.toString());
  JSONObject finalJson=new JSONObject(jsonTokener);