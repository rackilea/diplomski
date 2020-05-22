HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet(url);
    HttpResponse response = client.execute(request);

    String html = "";
    InputStream in = response.getEntity().getContent();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder str = new StringBuilder();
    String line = null;
    while((line = reader.readLine()) != null)
    {
        str.append(line);
    }
    in.close();
    html = str.toString();



   Log.i('HtmlContent',+html)