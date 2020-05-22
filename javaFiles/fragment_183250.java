Edits edits = service.edits();
Insert editRequest = edits
.insert(ApplicationConfig.PACKAGE_NAME,
   null /** no content */);
AppEdit edit = editRequest.execute();

Upload uploadRequest = edits
.images()
.upload(ApplicationConfig.PACKAGE_NAME,
   editId,
   "fr-FR",
   "Your image type",
   mediaContent); // Your image as an AbstractInputStreamContent
Image image = uploadRequest.execute();