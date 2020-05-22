@PostMapping(value = "/createUser")
public ResponseEntity createUser(@RequestParam("json") String json, @RequestParam("file") MultipartFile file) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    UserDTO userDTO = objectMapper.readValue(json, UserDTO.class);
    // Do something
    return new ResponseEntity<>(HttpStatus.OK);
}