String url = "https://api.orange.com/oauth/v2/token";
HttpClient client = HttpClientBuilder.create().build();
HttpPost post = new HttpPost(url);
post.setHeader("Authorization", "Basic Sisi");
HttpResponse response = client.execute(post);
BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }
//Print result