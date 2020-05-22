FileRepresentation entity = new FileRepresentation(file, mediaType); //create the fileRepresentation  

    FormDataSet fds = new FormDataSet(); //create the FormDataSet
    FormData fd = new FormData(key, entity); //create the Formdata using a key and a value (file)       
    fds.getEntries().add(fd); //add the form data to the set
    fds.setMultipart(true); //set the multipart value to true

    String url = "http://localhost/uploadPhoto";
    Optional<JsonRepresentation> opJrep = m_RestClient.postJson(url,fds,MediaType.MULTIPART_FORM_DATA, Optional.empty());