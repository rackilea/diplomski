@RequestMapping(value = "/v2/convertIntoJson", 
                method = RequestMethod.GET, 
                produces = "application/json")
public String getRssFeedAsJson() throws IOException {
    InputStream xml = getInputStreamForURLData("http://www.samplefeed.com/feed/");
    byte[] byteArray = IOUtils.toByteArray(xml);
    String xmlString = new String(byteArray);
    JSONObject xmlToJsonObject = XML.toJSONObject(xmlString);
    String jsonString = xmlToJsonObject.toString();
    byte[] jsonStringAsByteArray = jsonString.getBytes("UTF-8");
    String retValue = new String(jsonStringAsByteArray, "UTF-8");
    return retValue;
}

public static InputStream getInputStreamForURLData(String Url) {
    URL url = null;
    HttpURLConnection httpConnection = null;
    InputStream content = null;

    try {
        url = new URL(Url);
        System.out.println("URL::" + Url);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpConnection = (HttpURLConnection) conn;

        int responseCode = httpConnection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        content = (InputStream) httpConnection.getInputStream();
    } 
    catch (MalformedURLException e) {
        e.printStackTrace();
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
    return content;
}