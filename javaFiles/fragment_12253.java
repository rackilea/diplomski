public class JSONParser {
    static InputStream is = null;
    static JSONObject jobj = null;
    static String json = "";
    String url="http://www.fansplay.com/wsfptb20/FBS.svc/GetContestants";

    public JSONParser(){

    }


   public JSONObject makeHttpRequest(String url){

    JSONObject jo = null;
    jo = new JSONObject();

    try {
         jo.accumulate("APIUserName", "AFBK8@DL4EJMd6");
      jo.accumulate("country","8GB4HE1C-EFSD-4L17-VY2D-A27OC8C52F6M");
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    JSONObject job=new JSONObject();
    try {
        job.accumulate("aloha", jo);
    } catch (JSONException e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }

    Log.e("url", job.toString());
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(this.url);
        try {
            httppost.setEntity(new StringEntity(job.toString(), "UTF-    8"));

           //               httppost.toString();
        //              Log.e("url", httppost.toString());
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            HttpResponse httpresponse = httpclient.execute(httppost);
            HttpEntity httpentity = httpresponse.getEntity();
            is = httpentity.getContent();

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new   InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while((line = reader.readLine())!=null){
                    sb.append(line+"\n");   

                }
                is.close();
                json = sb.toString();
                Log.e("url", json);
                try {
                    jobj = new JSONObject(json);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    return jobj;

     }