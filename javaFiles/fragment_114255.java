@GetMapping("/files/{uuid}")
@ResponseBody
public ResponseEntity<byte[]> getFile(@PathVariable String uuid) {
    FileMetadata myFileData = fileService.getFileMetadata(uuid);
    org.springframework.core.io.Resource res = new FileSystemResource(myFileData.getPaht());
    byte[] data = IOUtils.toByteArray(res.getInputStream());
    HttpHeaders respHeaders = new HttpHeaders();
    respHeaders.setContentType(MediaType.valueOf(myFileData.getContentType()));
    respHeaders.setContentLength(res.getFile().length());
    respHeaders.setContentDispositionFormData("attachment", myFileData.getName());
    return new ResponseEntity<>(data ,respHeaders, HttpStatus.OK);
}