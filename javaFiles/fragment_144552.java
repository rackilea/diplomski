/***************************************************************************************************************************/
/*                        RETURNS Calendar List                                                                            */
/***************************************************************************************************************************/
//@param authKey, represents the token key ,Auth=......
public void calendarList(String authKey){ 

    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httpget = new HttpGet("https://www.google.com/calendar/feeds/default/allcalendars/full");
    httpget.setHeader("Authorization","GoogleLogin "+authKey);


    // Execute HTTP Post Request
    org.apache.http.HttpResponse response; 
    try {
        response = httpclient.execute(httpget);
        HttpEntity httpEntity = response.getEntity();

        InputStream stream = httpEntity.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line);
            Log.d("RESPONSE LIST",line+"\n");                               
        }



    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}