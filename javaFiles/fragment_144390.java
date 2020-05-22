@RequestMapping(path = "/download", method = RequestMethod.GET)
public ResponseEntity<Resource> download(String param) throws IOException {

    // ...

    Path path = Paths.get(file.getAbsolutePath());
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

    return ResponseEntity.ok()
            .headers(headers)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource);
}