public void upload() throws FileUploadException {
  ServletFileUpload servletUpload = new ServletFileUpload(new DiskFileItemFactory());
  upload(servletUpload);
}

public void upload(ServletFileUpload servletUpload) throws FileUploadException{
  if (request == null) {
    //do nothing - success is already false
  } else if (ServletFileUpload.isMultipartContent(request)) {
    uploadedObjects = servletUpload.parseRequest(request);
    success = true            
  }
}