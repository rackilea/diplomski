@PostMapping(value="/myContext/p", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MyResponse> doPost( ArrayList<String> strings) throws Exception{
        MyResponse response = new MyResponse();

        //code

        response.setData(strings);
        return new ResponseEntity<RestResponse>(response, HttpStatus.OK);
    }