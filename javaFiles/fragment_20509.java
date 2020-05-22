public class JsonParser extends AsyncTask<Void, Void, JSONObject> {

    public interface ParserListener {
        void onSuccess(JSONObject result);
        void onFailure();
    }

    private ParserListener listener;    
    private HashMap<String, String> params;
    private String method;
    private String url;
    String charset = "UTF-8";
    HttpURLConnection conn;
    DataOutputStream wr;
    StringBuilder result;
    URL urlObj;
    JSONObject jObj = null;
    JSONArray jAry = null;
    StringBuilder sbParams;
    String paramsString;

    public JsonParser(String url, String method, HashMap<String, String> params) {
        this.url = url;
        this.method = method;
        this.params = params;
    }

    public void setListener(ParserListener listener) {
        this.listener = listener;
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        sbParams = new StringBuilder();
        int i = 0;
        for (String key : params.keySet()) {
            try {
                if (i != 0) {
                    sbParams.append("&");
                }
                sbParams.append(key).append("=")
                        .append(URLEncoder.encode(params.get(key), charset));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }

        if (method.equals("POST")) {
            try {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Charset", charset);
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.connect();
                paramsString = sbParams.toString();
                wr = new DataOutputStream(conn.getOutputStream());
                wr.writeBytes(paramsString);
                wr.flush();
                wr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals("GET")) {
            if (sbParams.length() != 0) {
                url += "?" + sbParams.toString();
            }

            Log.d("URL",url);
            try {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setDoOutput(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Charset", charset);
                conn.setConnectTimeout(15000);
                conn.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            Log.d("JSON Parser", "result: " + result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        try {
            jObj = new JSONObject(result.toString());
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        /* executed on main thread */
        if (listener != null) {
            if (jsonObject != null) {
                listener.onSuccess(jsonObject);
            } else {
                listener.onFailure();
            }
        }
    }
}