@PostMapping(path = "/upload")
    @Headers("Content-Type: multipart/form-data")
    public ResponseEntity<Properties> upload(@RequestHeader(name = UID, required = false) String uid,
            @RequestPart("file") MultipartFile multiPart) {
        //Save Attachment.
    }