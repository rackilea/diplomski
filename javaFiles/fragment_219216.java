JSONObject jsonObject = new JSONObject(builder.toString());
JSONObject responseData = (JSONObject)jsonObject.get("responseData");
JSONArray results = (JSONArray)responseData.get("results");
for(int i = 0; i < results.length(); i++)
{
     JSONObject urlObject  = (JSONObject)results.get(i);
     System.out.println(urlObject.get("url"));
}