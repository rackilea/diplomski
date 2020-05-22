HttpClient httpClient = HttpClientBuilder.create().build(); 

try {

    HttpPost request = new HttpPost("https://localhost:9999/api/traces/%2f/login");
    StringEntity params =new StringEntity("{\"mobile_number\":\"09178005343\", \"pin\":\"1111\"");
    request.addHeader("content-type", "application/json");
    request.setEntity(params);
    HttpResponse response = httpClient.execute(request);

    //Do what you want with the response

}catch (Exception ex) {

    //If exception occurs handle it

} finally {
     //Close the connection 
}