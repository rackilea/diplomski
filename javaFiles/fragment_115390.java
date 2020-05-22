@PostMapping("/download")
open fun download(@RequestBody request: DownloadRequest, servletResponse: HttpServletResponse) {
    val file = getByteArray(request.fileId)
    servletResponse.contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE
    servletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${request.fileId}.zip\"")
    servletResponse.outputStream.write(file)
}