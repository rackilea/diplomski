HttpGet request = new HttpGet(new URI(url.toString()));
    HttpClient client = new DefaultHttpClient();
    HttpResponse response = client.execute(request);
    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
    StringBuilder builder = new StringBuilder();
    for (String line = null; (line = reader.readLine()) != null;) {
        builder.append(line).append("\n");
    }
    JSONObject jResponse = new JSONObject(builder.toString());