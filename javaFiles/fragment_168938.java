MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
map.add("param1", "123");
map.add("param2", "456");
map.add("param3", "789");
map.add("param4", "123");
map.add("param5", "456");

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

final HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map ,
        headers);
JSONObject jsonObject = null;

try {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.exchange(
            "https://url", HttpMethod.POST, entity,
            String.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
        try {
            jsonObject = new JSONObject(responseEntity.getBody());
        } catch (JSONException e) {
            throw new RuntimeException("JSONException occurred");
        }
    }
  } catch (final HttpClientErrorException httpClientErrorException) {
        throw new ExternalCallBadRequestException();
  } catch (HttpServerErrorException httpServerErrorException) {
        throw new ExternalCallServerErrorException(httpServerErrorException);
  } catch (Exception exception) {
        throw new ExternalCallServerErrorException(exception);
    }