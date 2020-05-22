@ExceptionHandler(RuntimeException.class)
 public ResponseEntity<String> RuntimeExceptionHandler(RuntimeException e) {
  JSONObject response = new JSONObject();
  response.put("message", e.getMessage());
  return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
 }