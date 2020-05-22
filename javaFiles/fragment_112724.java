@RequestMapping(value = "/company/UploadFile.action")
public ResponseEntity<String> Map<String, ? extends Object> uploadFile(UploadItem uploadItem, BindingResult result) throws Exception {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");

    // your controller logic goes here

    return new ResponseEntity<String>(response, responseHeaders, HttpStatus.OK);
}