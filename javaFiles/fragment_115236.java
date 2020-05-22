@Retryable(maxAttempts = 4, value = {ResourceAccessException.class}, backoff = @Backoff(delay = 5000))
public ResponseEntity<String> tryToSendAndReturnResponseByRestTemplate(final RestTemplate restTemplate,
                                                                       final HttpEntity<MyObjDTO>
                                                                               request) {

    return restTemplate.exchange(resolveUrl(ENDPOINT_ADDRESS), HttpMethod.POST, request, String.class);
}