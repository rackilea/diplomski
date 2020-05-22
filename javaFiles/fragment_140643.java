@ResponseBody
@RequestMapping(value = "get/pdf/{id}", headers="Accept=*/*", method = RequestMethod.GET)
public ResponseEntity<InputStreamResource> getPdfContractById(@PathVariable("id") Long id){
        // Get the remove file based on the fileaddress
        RemoteFile remotefile = new RemoteFile(id);

        // Set the input stream
        InputStream inputstream = remotefile.getInputStream();
        // asume that it was a PDF file
        HttpHeaders responseHeaders = new HttpHeaders();
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        responseHeaders.setContentLength(contentLengthOfStream);
        responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
        // just in case you need to support browsers
        responseHeaders.put("Content-Disposition", Collections.singletonList("attachment; filename=somefile.pdf"))
        return new ResponseEntity<InputStreamResource> (inputStreamResource,
                                   responseHeaders,
                                   HttpStatus.OK);
}