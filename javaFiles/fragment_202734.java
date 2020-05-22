private void getMyResponse()
{
    final String uri = "theRestWebServiceURI";
    RestTemplate restTemplate = new RestTemplate();

    MyResponse myResponse = restTemplate.getForObject(uri, MyResponse.class);

}