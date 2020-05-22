@ResponseBody ResponseEntity<? extends AbstractResponse> createUser(@RequestBody String requestBody) {
    if(!valid(requestBody) {
        ErrorResponse errResponse = new ErrorResponse();
        //populate with error information
        return new ResponseEntity<ErrorResponse> (errResponse, HTTPStatus.BAD_REQUEST);
    }
    createUser();
    CreateUserSuccessResponse successResponse = new CreateUserSuccessResponse();
    // populate with more info
    return new ResponseEntity<CreateUserSuccessResponse> (successResponse, HTTPSatus.OK);
}