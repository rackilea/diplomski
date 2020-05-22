public String getXmlFromUrl(String url)

{
    String xml = null;

    try

    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet, localContext);

        HttpEntity entity = response.getEntity();

        xml = getASCIIContentFromEntity(entity);


    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    // return XML
            return xml;
}