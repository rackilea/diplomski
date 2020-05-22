@RequestMapping(path = "/download", method = RequestMethod.GET)
public ResponseEntity<Resource> download(String param) throws IOException {

    // ...

    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

    return ResponseEntity.ok()
            .headers(headers)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource);
}