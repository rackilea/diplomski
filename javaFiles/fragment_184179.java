@RequestMapping(method = RequestMethod.POST, value = "/users/profile")
    public ResponseEntity<?> handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam(name="file", required=false) MultipartFile file) {

        log.info(" name : {}", name);
        if(file!=null)
        {   
            log.info("image : {}", file.getOriginalFilename());
            log.info("image content type : {}", file.getContentType());
        }
        return new ResponseEntity<String>("Uploaded",HttpStatus.OK);
    }