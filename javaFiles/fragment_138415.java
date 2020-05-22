HttpResponse response = client.execute(request);
char[] chars = new char[4096];
Reader rd = new InputStreamReader(response.getEntity().getContent());
StringWriter sw = new StringWriter();

for (int len; ((len = rd.read(chars)) > 0;)
     sw.write(chars, 0, len);

return (JSONObject)new JSONParser().parse(sw.toString());