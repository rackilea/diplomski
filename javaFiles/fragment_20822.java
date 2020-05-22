JSONObject jsonobj = new JSONObject();
JSONObject geoJsonObj = new JSONObject();
try {
    jsonobj.put("action","put-point");
    geoJsonObj.put("lng", longitude);
    geoJsonObj.put("lat", latitude);
    geoJsonObj.put("rangeKey", rangeKey);
    geoJsonObj.put("schoolName", "TESTSCHOOL535353");
    jsonobj.put("request", geoJsonObj);


 } catch (JSONException e) {
    e.printStackTrace();
 }
new SendData().execute(jsonobj.toString());

public class SendData extends AsyncTask<String, Integer, Double>{  
  String response="";  
    @Override  
    protected Double doInBackground(String... params) {  

            postData(params[0]);  

    }  




    public void postData(String jsondata)  {  

        // Create a new HttpClient and Post Header  
        HttpClient httpclient = new DefaultHttpClient();  

         HttpPost httpPost=new HttpPost("url");  
        try {  
            // Add your data  
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
            nameValuePairs.add(new BasicNameValuePair("json",jsondata));  


            httpPost.setEntity((HttpEntity) new UrlEncodedFormEntity(nameValuePairs));  

            // Execute HTTP Post Request  
            HttpResponse res = httpclient.execute(httpPost);  
             InputStream content = res.getEntity().getContent();  

              BufferedReader buffer = new BufferedReader(new InputStreamReader(content));  
              String s = "";  
              while ((s = buffer.readLine()) != null) {  
                response += s;  
              }  
              System.out.println("response from server"+response);  


        } catch (ClientProtocolException e) {  

            // TODO Auto-generated catch block  
        } catch (IOException e) {  

            // TODO Auto-generated catch block  
        }  
    }  
}