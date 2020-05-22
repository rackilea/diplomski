@GetMapping(value = Constants.API_LOGIN)
public String login(@RequestParam String userName, @RequestParam String password) throws JSONException  {
    ....
    JSONObject json = new JSONObject();
    json.put("status", true);
    json.put("message", "login success");
    return ResponseEntity.status(HttpStatus.OK).body(json.toString());
}