HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://foo.com/developers/apps.json");

        StringEntity input = new StringEntity(gson.toJson(myApp));
        input.setContentType("application/json;charset=UTF-8");
        input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
        request.setEntity(input);