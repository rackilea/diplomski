@RequestMapping(value = "/v1/hello", method = RequestMethod.GET)
public ResponseEntity<String> entry() {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<>("{\"msg\": \"Hello World\"}", httpHeaders, 
    HttpStatus.OK);
}