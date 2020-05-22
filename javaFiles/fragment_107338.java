@GetMapping(value = "/stream/test")
@ResponseBody
public ResponseEntity<?> getTestStream() {

    String myName = "name";
    InputStream stream = new ByteArrayInputStream(myName.getBytes(StandardCharsets.UTF_8));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");

    return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(new InputStreamResource(stream));
}