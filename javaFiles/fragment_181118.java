public ResponseEntity<String> postCustomerRequest(final HttpServletRequest request) {
    ...
    final org.codehaus.jackson.map.ObjectMapper mapperObj = new org.codehaus.jackson.map.ObjectMapper();
    CustomerResponse response=createCustomer(document,objectFactory);
    mapperObj.setPropertyNamingStrategy(new CustomerJsonNameStrategy());

    final HttpHeaders httpHeaders= new HttpHeaders();
    httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
    return new ResponseEntity<String>(mapperObj.writeValueAsString(response), httpHeaders, HttpStatus.OK);

}