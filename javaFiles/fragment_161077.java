@RequestMapping(value = URIConstansts.GET_FILE, produces = { "application/json" }, method = RequestMethod.GET)
public @ResponseBody ResponseEntity getFile(@RequestParam(value="fileName", required=false) String fileName,HttpServletRequest request) throws IOException{

    ResponseEntity respEntity = null;

    byte[] reportBytes = null;
    File result=new File("/home/arpit/Documents/PCAP/dummyPath/"+fileName);

    if(result.exists()){
        InputStream inputStream = new FileInputStream("/home/arpit/Documents/PCAP/dummyPath/"+fileName);
        String type=result.toURL().openConnection().guessContentTypeFromName(fileName);

        byte[]out=org.apache.commons.io.IOUtils.toByteArray(inputStream);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-disposition", "attachment; filename=" + fileName);
        responseHeaders.add("Content-Type",type);

        respEntity = new ResponseEntity(out, responseHeaders,HttpStatus.OK);
    }else{
        respEntity = new ResponseEntity ("File Not Found", HttpStatus.OK);
    }
    return respEntity;
}