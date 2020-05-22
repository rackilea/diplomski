@ExceptionHandler
public ResponseEntity<JSONReturned> exception(NoHandlerFoundException exception){

    ResponseEntity<JSONReturned> responseEntity = null;
    JSONReturned jsonReturned = new JSONReturned();
    jsonReturned.setMsg("Sorry your request cannot be completed.");
    jsonReturned.setResponse("Requested URL is not present.");
    responseEntity = new ResponseEntity<JSONReturned>(jsonReturned, HttpStatus.BAD_REQUEST);
    return responseEntity;
}