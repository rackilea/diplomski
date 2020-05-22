public static String getStringPage(String url){
    StringBuffer stringBuffer = new StringBuffer();
    BufferedReader bufferedReader = null;
    HttpClient httpClient = null;
    HttpGet httpGet = null;
    URI uri = null;
    HttpResponse httpResponse = null;
    InputStream inputStream = null;
    String HTMLCode = null;


    //Create client and a query to get the page
        httpClient = new DefaultHttpClient();
        httpGet = new HttpGet();

        //Set the query with the url in parameter
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        httpGet.setURI(uri);

        //Execute the query
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create a buffer to get the page
        try {
            inputStream = httpResponse.getEntity().getContent();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //Get the buffer caracters
    try {
        HTMLCode = bufferedReader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    while (HTMLCode!= null){
        stringBuffer.append(HTMLCode);
        stringBuffer.append("\n");
        try {
            HTMLCode = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Return the string of the page code
    return stringBuffer.toString();
}