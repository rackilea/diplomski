else
  {
     response = uploadSuccessHandler == null || uploadSuccessHandler.onUploadSuccess(new UploadSuccessEvent(file, serverData, responseReceived));
  }

  return response;