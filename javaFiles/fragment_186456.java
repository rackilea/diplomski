/*
 * returns rendered highcharts image
 */
public static void getRenderedImage(String json) {
    HttpClient httpClient = HttpClientBuilder.create().build(); 

    try {

        HttpPost request = new HttpPost("http://export.highcharts.com");
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("content", "options"));
        postParameters.add(new BasicNameValuePair("options", json));
        postParameters.add(new BasicNameValuePair("constr", "Chart"));
        postParameters.add(new BasicNameValuePair("type", "png"));

        request.setEntity(new UrlEncodedFormEntity(postParameters));

        HttpResponse response = httpClient.execute(request);


        // write the inputStream to a FileOutputStream
        OutputStream outputStream =
                    new FileOutputStream(new File("/Users/joern/bild11.png"));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = response.getEntity().getContent().read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        outputStream.close();

    }catch (Exception e) {
        e.printStackTrace();
    }
}