@RequestMapping(method = RequestMethod.GET)
public ResponseEntity getUser(@RequestHeader(value="Access-key") String accessKey,
                              @RequestHeader(value="Secret-key") String secretKey) {
    try {
        // see note 1
        return ResponseEntity
            .status(HttpStatus.CREATED)                 
            .body(this.userService.chkCredentials(accessKey, secretKey, timestamp));
    }
    catch(ChekingCredentialsFailedException e) {
        e.printStackTrace(); // see note 2
        return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("Error Message");
    }
}