<T> ResponseEntity<T> makeApiCall(
    String path, HttpMethod httpMethod, T body, Class<T> bodyClass, 
    boolean isAdmin){
  // ...
  ResponseEntity<T> responseEntity =
      restTemplate.exchange(
          path, HttpMethod.POST, entity, bodyClass);
  // ...
}