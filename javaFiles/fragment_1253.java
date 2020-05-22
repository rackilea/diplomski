@RequestMapping("/")
public ResponseEntity<Resource> download() {
  HttpHeaders httpHeaders = new HttpHeaders();
  String filename = "русское_слово.txt";

  ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
      .filename(filename, StandardCharsets.UTF_8)
      .build();
  httpHeaders.setContentDisposition(contentDisposition);

  return new ResponseEntity<>(new ByteArrayResource(new byte[0]),
      httpHeaders, HttpStatus.OK);
}