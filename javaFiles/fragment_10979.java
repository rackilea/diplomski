@PostMapping(value="/borrow")
public ResponseEntity<Void> postBorrowBook(@RequestBody RequestDTO requestBody) {
    requestBody.getPersonId();
    requestBody.getBookId();
    ...
}