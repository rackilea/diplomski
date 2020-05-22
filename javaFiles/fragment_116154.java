@RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/zip")
public ResponseEntity<StreamingResponseBody> getFile() throws Exception {

    InputStream[] streamsToZip = getStreamsFromAzure();

    // You could cache already created zip files, maybe something like this:
    //   String[] pathsOfResourcesToZip = getPathsFromAzure();
    //   String zipId = getZipId(pathsOfResourcesToZip);
    //   if(isZipExist(zipId))
    //     // return that zip file
    //   else do the following

    StreamingResponseBody streamResponse = clientOut -> {
        FileOutputStream zipFileOut = new FileOutputStream("test.zip");

        ZipOutputStream zos = new ZipOutputStream(new SplitOutputStream(clientOut, zipFileOut));
        for (InputStream in : streamsToZip) {
            addToZipFile(zos, in);
        }
    };

    return ResponseEntity.ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "download.zip")
            .contentType(MediaType.parseMediaType("application/zip")).body(streamResponse);
}


private void addToZipFile(ZipOutputStream zos, InputStream fis) throws IOException {
    ZipEntry zipEntry = new ZipEntry(generateFileName());
    zos.putNextEntry(zipEntry);
    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0) {
        zos.write(bytes, 0, length);
    }
    zos.closeEntry();
    fis.close();
}