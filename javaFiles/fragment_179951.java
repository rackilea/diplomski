@GetMapping("/download1")
       public ResponseEntity<InputStreamResource> downloadFile1() throws IOException {

          File file = new File(FILE_PATH);
          InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

          return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                      "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(resource);
       }