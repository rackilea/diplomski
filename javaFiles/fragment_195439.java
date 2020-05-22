@GetMapping(value = Constants.API_LOGIN)
public ResponseEntity<Object> login(@RequestParam String userName, @RequestParam String password) throws JSONException  {
    .....
    Map<String, Object> json = new HashMap<>();
    json.put("status", true);
    json.put("message", "login success");
    return ResponseEntity.status(HttpStatus.OK).body(json);
}