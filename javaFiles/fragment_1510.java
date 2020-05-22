@Test
public void testRetrieveWeather() {

    MultiValueMap<String, String>multiValue=new LinkedMultiValueMap<>();

    // use a mock here
    RestTemplate objRestTemplate = mock(RestTemplate.class); 
    Mockito.when(weatherUtilies.buildRequestParams(Mockito.anyString()))
                    .thenReturn(multiValue);
    doReturn(objRestTemplate).when(restTemplate).buildRestTemplate();
    ResponseEntity<String> responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.OK);

    // fix the exception you get by defining behaviour on the mocked object.
    doReturn(responseEntity).when(objRestTemplate).exchange(
                               Matchers.anyString(), 
                               Matchers.any(HttpMethod.class),
                               Matchers.<HttpEntity<?>> any(), 
                               Matchers.<Class<String>> any()
                              );
    assertEquals(weatherRemote.retrieveWeather("ciaro").getStatusCode(), HttpStatus.OK);
}