@RequestMapping(value = "/action/{abcd}/{efgh}", method = RequestMethod.GET)
@PreAuthorize("@authorizationService.authorizeMethod(#id)")
public HttpEntity<byte[]> doAction(@PathVariable ObjectType obj, @PathVariable Date date, HttpServletResponse response) throws IOException {
    ZipFileType zipFile = service.getFile(obj1.getId(), date);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    response.setHeader("Content-Disposition", "attachment; filename=" + zipFile.getFileName());

    return new HttpEntity<byte[]>(zipFile.getByteArray(), headers);
}