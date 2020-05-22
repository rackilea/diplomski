private String getServerContentsJson()
    throws IOException {
    HttpClient httpclient = new DefaultHttpClient();

    String responseString = null;
    HttpResponse response = null;
    try {
      response = httpclient.execute(new HttpGet(url));

      StatusLine statusline = response.getStatusLine();

      if (statusline.getStatusCode() == HttpStatus.SC_OK) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.getEntity().writeTo(out);
        responseString = out.toString();
        out.close();
        return responseString;
      } else {
        responseString = statusline.getReasonPhrase();
      }
    } catch (IOException e) {
      throw new IOException(e.getMessage(), e);
      //OR:
      //responseString = "Could not reach server, please try again";
    } finally {
      if (response != null) {
        response.getEntity().consumeContent();
      }
    }
    return responseString;
  }