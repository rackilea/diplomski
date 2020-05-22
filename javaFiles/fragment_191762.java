public class JSONfunctions {

public static JSONArray getJSONfromURL(String url) {
    InputStream is = null;
    String result = "";
    JSONArray jArray = null;

    // Download JSON data from URL
    try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();

    } catch (Exception e) {
        Log.e("log_tag", "Error in http connection " + e.toString());
    }


       StringBuffer sb = new StringBuffer("");
    try {
        URL urls = new URL(url);
        URLConnection urlConnection;
        urlConnection = urls.openConnection();
        InputStream in = urlConnection.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
         String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb);
            result=sb.toString();
    } catch (IOException e) {}
      catch (Exception e) {}
    try {

        jArray = new JSONArray(result);
    } catch (JSONException e) {
        Log.e("log_tag", "Error parsing data " + e.toString());
    }

    return jArray;
   }
  }