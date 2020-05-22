private static final String TAG = "YourClassNameHere"

    public String makeHttpRequestJsonString(String phpScript, Map<String, String> params){
        String json = "";
        InputStream responseStream = null;

        String logMess = "";
        long startTime;
        long stopTime;
        long elapsedTime;

        // Replace as needed (with subdirectories as needed)
        String host = "Http://yourWebSite.com/dir1/dir2/";
        host =+ "/" + phpScript

        // I've changed my code here considerable  to simplify it 
        // so you will need to check your URL
        URL url = new URL(host);

        try {
            // Added to observe the performance of the download
            startTime = System.currentTimeMillis();

            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String, String> param : params.entrySet()){
                param.getValue());
                if(postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
postData.toString());

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

            DataOutputStream request = new DataOutputStream(conn.getOutputStream());
            request.write(postDataBytes);
            request.flush();
            //I've heard some people have issues if they close the request -- I have not
            request.close();

            //Check the response code of the server -
            Integer replyCode = conn.getResponseCode();
            logMess += "   Reply Code:  " + replyCode.toString();

            responseStream = new BufferedInputStream(conn.getInputStream());
            BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));

            stopTime = System.currentTimeMillis();
            elapsedTime = stopTime - startTime;
            logMess += "   elapsed Time :  " + elapsedTime + " ms";

            // I dump this to the error log -- it is easier to see
            // but in production all unnecessary logging should be removed
            Log.e(TAG, "makeHttpRequestJsonString --- " + logMess);
            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            responseStreamReader.close();

            json = stringBuilder.toString();
        }
        catch (UnsupportedEncodingException e) {
            Log.e(TAG, "makeHttpRequestJsonString --- " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "makeHttpRequestJsonString --- " + e.getMessage());
        }
        // You are now returning the JSON encoded string results
        return json;
    }