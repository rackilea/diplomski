HttpClient httpClient = HttpClientBuilder.create().build();

    try {
        HttpPost request = new HttpPost("http://localhost:8080/engine-rest/process-definition/key/demo-scaling/start");
        StringEntity params =new StringEntity("variables={\"businessKey\":\"AAA001\"}");
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);

        System.out.println(response);
    }catch (Exception ex) {
        // handle Exceptions
    }