private boolean callSOAPWebService(String data) {
        OutputStream out = null;
        int respCode;
        boolean isSuccess = false;
        URL url;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(GetData.NonOpDomain);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            do {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", "text/xml");
                httpURLConnection.setRequestProperty("SendChunked", "True");
                httpURLConnection.setRequestProperty("UseCookieContainer", "True");
                HttpURLConnection.setFollowRedirects(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setRequestProperty("Content-length", getReqData(data).length + "");
                httpURLConnection.setReadTimeout(100 * 1000);
                // httpURLConnection.setConnectTimeout(10 * 1000);
                httpURLConnection.connect();
                out = httpURLConnection.getOutputStream();
                if (out != null) {
                    out.write(getReqData(data));
                    out.flush();
                }
                respCode = httpURLConnection.getResponseCode();
                Log.e("respCode", ":" + respCode);
            } while (respCode == -1);

            // If it works fine
            if (respCode == 200) {
                try {
                    InputStream responce = httpURLConnection.getInputStream();
                    String str = convertStreamToString(responce);
                    System.out.println(".....data....." + str);
                    InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
                    XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();
                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(is, null);
                    parseXMLAndStoreIt(myparser);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                isSuccess = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out = null;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                httpURLConnection = null;
            }
        }
        return isSuccess;
    }