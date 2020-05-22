@RequestMapping(value="/download/{fileid}", method = RequestMethod.GET)
public ResponseEntity<InputStreamResource> download(@PathVariable Integer fileid, HttpServletResponse response) {
    File file = new   File((directoryService.findBydata("feedback").getPath()).trim()+"\\"+ (fileservice.findByfileid(fileid).getfilename()).trim());
    if(file.exists()){
        try {
            InputStream fis = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(fis);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+(fileservice.findByfileid(fileid).getfilename()).trim())
                    .body(inputStreamResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}