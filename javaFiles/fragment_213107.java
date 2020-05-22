@PostMapping(path = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String hello(@RequestBody Pojo1 val) {
    return "Hello";
  }

  @PostMapping(path = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String hello(@RequestBody Pojo2 val) {
    return "Hello";
  }