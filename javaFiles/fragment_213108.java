@PostMapping(path = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String hello(@RequestBody Pojo val) {
    return "Hello";
  }

  @PostMapping(path = "/hello", consumes = MediaType.TEXT_PLAIN_VALUE)
  public String hello(@RequestBody String val) {
    return "Hello";
  }