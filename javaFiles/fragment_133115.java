private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
      String response = "";
      for (String url : urls) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
          HttpResponse execute = client.execute(httpGet);
          InputStream content = execute.getEntity().getContent();

          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
          String s = "";
          while ((s = buffer.readLine()) != null) {
            response += s;
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return response;
    }

    @Override
    protected void onPostExecute(String result) {
      textView.setText(result);
    }
  }