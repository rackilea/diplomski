private static final String FORM_TARGET = "http://www.indianrail.gov.in/cgi_bin/inet_pnstat_cgi.cgi";
private static final String INPUT_PNR = "lccp_pnrno1";
private static final String INPUT_CAPTCHA = "lccp_capinp_val";
private static final String INPUT_CAPTCHA_HIDDEN = "lccp_cap_val";

private void getHtml(String userPnr) {
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.addTextBody(INPUT_PNR, userPnr); // users PNR code
    builder.addTextBody(INPUT_CAPTCHA, "123456");
    builder.addTextBody("submit", "Get Status");
    builder.addTextBody(INPUT_CAPTCHA_HIDDEN, "123456"); // values don't
                                                            // matter as
                                                            // long as they
                                                            // are the same

    HttpEntity entity = builder.build();

    HttpPost httpPost = new HttpPost(FORM_TARGET);
    httpPost.setEntity(entity);

    HttpClient client = new DefaultHttpClient();

    HttpResponse response = null;
    String htmlString = "";
    try {
        response = client.execute(httpPost);
        htmlString = convertStreamToString(response.getEntity().getContent());
                // now you can parse this string to get data you require.
    } catch (Exception letsIgnoreItForNow) {
    }
}

private static String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
    } catch (IOException ignoredOnceMore) {
    } finally {
        try {
            is.close();
        } catch (IOException manyIgnoredExceptions) {
        }
    }

    return sb.toString();
}