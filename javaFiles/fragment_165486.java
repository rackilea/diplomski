public String someMethod() throws Exception 
{
    Map reqMap = new LinkedHashMap();//contains your parameter and values
    reqMap.put("parameter1", "value1");
    reqMap.put("parameter2", value2);
    HttpClient client = new DefaultHttpClient();;
    HttpEntity httpEntity = null;
    String result=null;

    HttpPost httpPost = new HttpPost("url to jsp");
    httpPost.setHeader("Content-Type","application/json");
    httpPost.setHeader("Accept", "application/json");
    int statusCode = 0;
    try
    {
        JSONObject holder = new JSONObject(reqMap);//convert it to jsonObject
        StringEntity stringEntity = new StringEntity(holder.toString());//convert it to StringEntity
        httpPost.setEntity(stringEntity);//set the entity
        httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse httpResponse = client.execute(httpPost);
        httpEntity = httpResponse.getEntity();
        statusCode = httpResponse.getStatusLine().getStatusCode(); 
        if (statusCode == HttpStatus.SC_OK) 
        {
            //do some work
        } 
        else 
        {
            //do some work
        }
        return statusMessage;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}