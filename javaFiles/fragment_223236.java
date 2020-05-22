URI website;
try {
    HttpClient client = new DefaultHttpClient();
    website = new URI("http://"+ IP+ ":8080/ServerName/ServletName");
    HttpPost request = new HttpPost();
    request.setHeader("Data Name", Data Value);
    request.setURI(website);
    HttpResponse response = client.execute(request);
    // Response From Server
    Header[] headers = response.getAllHeaders();
    for (int i = 0; i < headers.length; i++) {
    Header h = headers[i];
    }
    } catch (URISyntaxException e) {
         e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
   }