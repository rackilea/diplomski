@RequestMapping(value = "/get2", method = RequestMethod.POST)
public ResponseEntity<String> get2(@RequestBody MyObj parm) {

    String response = "You entered " + parm.getInputValue();
    return new ResponseEntity<>(response, HttpStatus.OK);
}