class URLParams extends HandlerParams {
  // whatever...
}  

class URLFileHandler implements FileHandler<URLParams> {

  @Override
  public boolean uploadFile(URLParams parameters) {
    // ...
  }

  @Override
  public OutputStream downloadFile(URLParams parameters) {
    // ...
  }    
}