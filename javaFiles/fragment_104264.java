public static String getContentFromUrl(String url) throws ClientProtocolException, IOException {

    HttpClient httpClient = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet(url);
    HttpResponse response;

    response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();

    if (entity != null) {

        InputStream inStream = entity.getContent();

        String result = HttpService.convertStreamToString(inStream);
        inStream.close();

        return result;
    }

    return null;
}

private static String convertStreamToString(InputStream is) {

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