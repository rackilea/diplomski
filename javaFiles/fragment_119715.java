@RequestMapping(value = "/DownloadPDFSaved/{group}", method = RequestMethod.GET)
public void downloadGroup(@PathVariable String group, HttpServletResponse response) {
    if(!StringUtils.hasText(group)) {
         response.sendError(400, "Group is empty");
        return;
    }

    File zipFile = new File(getPDFZipFilePathForGroup(group));
    //set content-length header
    response.setHeader("Content-Length", Long.toString(zipFile.length()));         
    InputStream is = new FileInputStream(zipFile);
    IOUtils.copy(is, response.getOutputStream());
    response.flushBuffer();
}