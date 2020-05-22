URIBuilder builder = new URIBuilder().setScheme("http")
        .setHost("acousticbrainz.org")
        .setPath("/8e160042-b451-4f96-b59a-d06831d2ae05/high-level");

HttpUriRequest httpUriRequest = new HttpGet(builder.build());

HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpUriRequest);

String response = EntityUtils.toString(httpResponse.getEntity());

JSONObject jsonObject = new JSONObject(response);

System.out.println(jsonObject.toString());