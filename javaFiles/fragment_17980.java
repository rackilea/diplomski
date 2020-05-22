//Here your mapping annotation
public @ResponseBody ResponseEntity<?> getSuccessOrError() {

    //Body omitted
    //in case of success return new ResponseEntity(YourSuccessClass, HttpStatus)
    //in case of error return new ResponseEntity(YourErrorClass, HttpStatus)

}