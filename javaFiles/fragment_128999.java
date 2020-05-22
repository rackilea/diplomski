@TargetApi(Build.VERSION_CODES.GINGERBREAD)
  public boolean postToServer(String url, String postData, StringBuilder resultData) throws IOException {
    URL at_url = new URL(url);
    int responseCode = 0;
    try {
      HttpURLConnection httpUrlConnection = (HttpURLConnection) at_url.openConnection();

      httpUrlConnection.setUseCaches(false);
      httpUrlConnection.setRequestProperty("User-Agent", "MyAgent");
      httpUrlConnection.setConnectTimeout(30000);
      httpUrlConnection.setReadTimeout(30000);

      httpUrlConnection.setRequestMethod("POST");
      httpUrlConnection.setDoOutput(true);

      OutputStream os = httpUrlConnection.getOutputStream();
      try {
        os.write(postData.getBytes(Charset.forName("UTF-8")));
      } finally {
        os.flush();
        os.close();
      }

      httpUrlConnection.connect();

      String response = "";
      responseCode = httpUrlConnection.getResponseCode();
      if (responseCode == 200) {
        InputStream is = httpUrlConnection.getInputStream();
        response = convertStreamToString(is);
        // Read is to get results
      } else {
        InputStream is = httpUrlConnection.getErrorStream();
        response = convertStreamToString(is);
        // Read is to get error
      }
      resultData.append(response);

    }
    finally {
      // Cleanup
    }
    return responseCode == 200;
  }