@Scheduled(cron = "0 9 1-7 * 1 *") // first monday of each month, at 9am
public void dataLoaderTask() throws Exception {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpPost httppost = new HttpPost("https://erudite-master-api-awsmaui.lab.expts.net/erudite/search");
    List<NameValuePair> params = new ArrayList<NameValuePair>(3);
    params.add(new BasicNameValuePair("action", "count"));
    params.add(new BasicNameValuePair("fields", "Status"));
    params.add(new BasicNameValuePair("filters", ""));
    httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
    // Execute and get the response.
    CloseableHttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    if (entity != null) {
        InputStream instream = entity.getContent();
        try {
            // do something useful
        } finally {
            instream.close();
        }
    }
}