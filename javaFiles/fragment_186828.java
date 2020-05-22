@Override
public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){

//Save_form

  if(success){
      //serveFile
      String documentPath = document.getDocumentPath();

      File file = getFile(documentPath);

      String contentType = MimeTypesUtil.getContentType(file);

      long contentLength = file.length();

      is = new FileInputStream(file);

      ServletResponseUtil.sendFile(
          request, response, document.getDocumentName(), is, contentLength, contentType,
          HttpHeaders.CONTENT_DISPOSITION_INLINE);

  }else{

      response.getOutputStream("Error submitting form");
      response.getOutputStream().flush();
  }   

}