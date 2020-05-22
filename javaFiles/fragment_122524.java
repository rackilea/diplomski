public static String getStrResponse(String url, List<NameValuePair> params) {
        try {

            HttpClient httpclient = createHttpClient();
            HttpPost httppost = new HttpPost(url);

            List<NameValuePair> nameValuePairs = params;

            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            InputStream in = entity.getContent();

            BufferedReader bReader = new BufferedReader(new InputStreamReader(
                    in));

            StringBuffer str = new StringBuffer();
            String line = null;

            while ((line = bReader.readLine()) != null) {
                str.append(line);
            }

            return str.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "FALSE";
    }