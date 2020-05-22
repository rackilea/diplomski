public static String excutePost(String[][] urlParameters) {
        try {
            String param = encode(urlParameters);
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(APP_URI);
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("app_id", APP_NAME));
            params.add(new BasicNameValuePair("enc_request", param));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String res = EntityUtils.toString(entity);
                return res;
            }
        } catch (IOException e) {
            return null;
        }

        return null;
    }