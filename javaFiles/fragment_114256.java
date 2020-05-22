@GetMapping("/client/files/{uuid}")
@ResponseBody
public ResponseEntity<org.springframework.core.io.Resource> getFile(@PathVariable String uuid) {
    byte[] data = resourceControllerApi.getFileUsingGET(uuid);
    HttpHeaders responseHeader = (HttpHeaders) RequestContextHolder.getRequestAttributes().getAttribute("responseHeader", RequestAttributes.SCOPE_REQUEST);
    return new ResponseEntity<>(new ByteArrayResource(data), responseHeader, HttpStatus.OK);
}