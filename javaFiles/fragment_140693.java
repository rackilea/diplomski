AbstractAjaxBehavior fileUploadBehavior = new AbstractDefaultAjaxBehavior() {
  @Override
  protected synchronized void respond(AjaxRequestTarget target) {
    RequestCycle requestCycle = getRequestCycle();

    // Prevent default redirection.
    requestCycle.scheduleRequestHandlerAfterCurrent(null);

    ServletWebRequest request = (ServletWebRequest) requestCycle.getRequest();
    ServletFileUpload servletFileUpload = new ServletFileUpload(YourFileItemImpl::new);

    try {
      // Initialize JSON response.
      JSONObject jsonResponse = new JSONObject();
      JSONArray jsonFiles = new JSONArray();
      jsonResponse.put("files", jsonFiles);

      // Parse and persist uploaded file(s).
      List<FileItem> fileItems = servletFileUpload.parseRequest(request.getContainerRequest());
      // Iterate file items to build JSON response.
      for (FileItem item : fileItems) {
        JSONObject jsonFile = new JSONObject();
        jsonFiles.put(jsonFile);

        jsonFile.put("name", item.getName());
        jsonFile.put("size", item.getSize());

        // TODO Perform validation, e.g. using Apache Tika for file type detection.
        //      Add any error using `jsonFile.put("error", "[error_message]")`. Should
        //      of course take care to not persist invalid files...
     }

     // Write JSON response.
     WebResponse response = (WebResponse) requestCycle.getResponse();
     response.setHeader("Content-Type", "text/html; charset=utf8"); // Because IE...
     response.write(jsonResponse.toString());
   } catch (FileUploadException | IOException | JSONException e) {
     // TODO Handle exception.
   }
 }