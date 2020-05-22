private void sendPostRequest(String givenUsername, String givenPassword) {

    class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String paramUsername = params[0];
            String paramPassword = params[1];

            System.out.println("*** doInBackground ** paramUsername "
                + paramUsername + " paramPassword :" + paramPassword);

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(
                "http://lib-dm.process9.com/libertydm/ValidateUserHandler.ashx");// replace with your url
            httpPost.addHeader("Content-type",
                "application/x-www-form-urlencoded");
            BasicNameValuePair usernameBasicNameValuePair = new BasicNameValuePair(
                "UserId", paramUsername);  // Make your own key value pair
            BasicNameValuePair passwordBasicNameValuePAir = new BasicNameValuePair(
                "Password", paramPassword);// make your own key value pair

            // You can add more parameters like above

            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
            nameValuePairList.add(usernameBasicNameValuePair);
            nameValuePairList.add(passwordBasicNameValuePair);

            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(
                    nameValuePairList);
                httpPost.setEntity(urlEncodedFormEntity);

                try {
                    HttpResponse httpResponse = httpClient
                        .execute(httpPost);
                    InputStream inputStream = httpResponse.getEntity()
                        .getContent();
                    InputStreamReader inputStreamReader = new InputStreamReader(
                        inputStream);
                    BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String bufferedStrChunk = null;
                    while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                        stringBuilder.append(bufferedStrChunk);
                    }

                    return stringBuilder.toString();

                    } catch (ClientProtocolException cpe) {
                        System.out
                            .println("First Exception coz of HttpResponese :"
                                + cpe);
                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        System.out
                            .println("Second Exception coz of HttpResponse :"
                                + ioe);
                        ioe.printStackTrace();
                    }

            } catch (UnsupportedEncodingException uee) {
                System.out
                    .println("An Exception given because of UrlEncodedFormEntity argument :"
                        + uee);
                uee.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }

    SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
    sendPostReqAsyncTask.execute(givenUsername, givenPassword);
}