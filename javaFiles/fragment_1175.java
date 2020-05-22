HttpHeaders resHeaders = new HttpHeaders();
resHeaders.add("Content-Type", "application/xml; charset=utf-8");
resHeaders.add("Content-Type", "text/event-stream; charset=utf-8");
if(!isError){
return new ResponseEntity<String>(responseXml, resHeaders, HttpStatus.OK);
}
else{
return new ResponseEntity<com.test.pack.fault.Error>(error, resHeaders,HttpStatus.CREATED);
    }