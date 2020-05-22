@RequestMapping(value = "/export", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
public ResponseEntity<String> export(...

HttpHeaders headers = new HttpHeaders();
headers.setAccessControlExposeHeaders(Collections.singletonList("Content-Disposition"));
headers.set("Content-Disposition", "attachment; filename=" + filename);
return new ResponseEntity<>(exportedContent, headers, HttpStatus.OK);