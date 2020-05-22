HttpStatus status;
if (condition) {
    status = HttpStatus.CONFLICT;
else if (condition2) {
    status = HttpStatus.PRECONDITION_FAILED;
else {
    status = HttpStatus.OK;
}

return new ResponseEntity<Domain>(domain, status);