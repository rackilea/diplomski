private static String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the
     * BufferedReader.readLine() method. We iterate until the BufferedReader
     * return null which means there's no more data to read. Each line will
     * appended to a StringBuilder and returned as String.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();
}

/*
 * This is a test function which will connects to a given rest service and
 * prints it's response to Android Log with labels "Praeda".
 */
public static String[] connect(String url) {
    HttpClient httpclient = new DefaultHttpClient();
    String[] str = new String[5];

    // Prepare a request object
    HttpGet httpget = new HttpGet(url);

    // Execute the request
    HttpResponse response;
    try {
        response = httpclient.execute(httpget);
        // Examine the response status
        Log.d(TAG, response.getStatusLine().toString());

        // Get hold of the response entity
        HttpEntity entity = response.getEntity();
        // If the response does not enclose an entity, there is no need
        // to worry about connection release

        if (entity != null) {

            // A Simple JSON Response Read
            InputStream instream = entity.getContent();
            String result = convertStreamToString(instream);
            result=result.replace("parseExchangeRate(", "").replace(");", "");
            Log.d(TAG, result);

            // A Simple JSONObject Creation
            JSONObject json = new JSONObject(result);
            Log.d(TAG, "<jsonobject>\n" + json.toString()
                    + "\n</jsonobject>");

            // A Simple JSONObject Parsing
            // JSONArray nameArray=json.names();
            // Log.i("query",nameArray.toString());
            // JSONObject query=json.getJSONObject("query");
            // Log.i("query",query.toString());
            // JSONArray results=query.getJSONArray("results");
            // Log.i("rslts",results.toString());
            // JSONArray quote=results.getJSONArray("quote");
            // JSONObject quote=results.getJSONObject("quote");
            // Log.i("quote",quote.toString());
            JSONObject query = json.getJSONObject("query");
            Log.d(TAG, query.toString());
            JSONObject results = query.getJSONObject("results");
            Log.d(TAG, results.toString());
            JSONObject quote = results.getJSONObject("row");
            Log.d(TAG, quote.toString());
            for (int i = 0; i < quote.length(); i++) {

                // Log.i("Praedafor","<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
                // +"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
                // JSONObject quotes = results.getJSONObject(i)
                // .getJSONObject("quote");
                // Log,i
                // Log.i("name",quote.getString("Name"));
                // Log.i("name","pahunch");
                // Log.i("name",quote.getString("Symbol"));

                // Log.i("name",quote.getString("DaysLow"));

                // Log.i("name",quote.getString("DaysHigh"));

                // Log.i("name",quote.getString("Open"));

                // Log.i("name",quote.getString("PreviousClose"));
                String symbol = quote.getString("rate");
                str[0] = symbol;
                String dayslow = quote.getString("DaysLow");
                str[1]=dayslow;
                // tv1.setText(quote.getString("DaysLow"));
                str[2]= quote.getString("DaysHigh");
                str[3]= quote.getString("Open");
                str[4]= quote.getString("Change");
            }

            // A Simple JSONObject Value Pushing
            // json.put("execution-start-time", "sample value");
            Log.d(TAG, "<jsonobject>\n" + json.toString()
                    + "\n</jsonobject>");
            // Log.i("Praeda12",json.get("").toString());

            // Closing the input stream will trigger connection release
            instream.close();
        }

    } catch (ClientProtocolException e) {
        Log.d(TAG, "ClientProtocolException");
        e.printStackTrace();
    } catch (IOException e) {
        Log.d(TAG, "IOException " + e.getMessage());
        e.printStackTrace();
    } catch (JSONException e) {
        Log.d(TAG, "JSONException " + e.getMessage());
        e.getMessage();
    }
    return str;
}