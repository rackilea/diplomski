RestTemplate restTemplate = new RestTemplate();
MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

mockServer.expect(requestTo("/greeting"))
  .andRespond(withSuccess("Hello world", "text/plain"));

// use RestTemplate ...

mockServer.verify();