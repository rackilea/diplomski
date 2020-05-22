@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/myredirect", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public void downloadFile(HttpServletResponse response) {
    // Remove this instruction if you wish to disable the download dialog.
    response.setHeader("Content-Disposition", "attachment; filename=filename.ext");

    // Load your file content as byte.
    byte[] fileContent = IOUtils.toByteArray(new ClasspathResource("myfile").getIntputStream());

    response.getOutputStream().write(fileContent);
}