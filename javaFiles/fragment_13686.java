@ApiImplicitParams (value = {
    @ApiImplicitParam(dataType = "file", name = "file", required = true,paramType = "form")}
@RequestMapping(value = "/scan", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
public ScanResult scan(HttpServletRequest request) throws IOException, FileUploadException {
    return scanService.scanFile(parseMultipart(request));
}