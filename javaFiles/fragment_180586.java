private final RestOperations restClient;

public EncoderService(RestOperations restClient) {
  this.restClient = restClient;
}

public ResponseEntity<Object> createNewStream(Long channelId) {
  ...
  ResponseEntity<Object> response = restClient.postForEntity(...
  ...
}