router.route().handler(BodyHandler.create());
router.post("/some/path/uploads").handler(routingContext -> {
    MultiMap attributes = routingContext.request().formAttributes();
    // do something with the form data
    Set<FileUpload> uploads = routingContext.fileUploads();
    // Do something with uploads....
});