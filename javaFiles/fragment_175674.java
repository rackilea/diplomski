FileService fileService = FileServiceFactory.getFileService();
AppEngineFile blobFile = fileService.getBlobFile(blobKey);
FileReadChannel readChannel = fileService.openReadChannel(blobFile, false);
byte[] imageData = getBytes(Channels.newInputStream(readChannel));
Image oldImage = ImagesServiceFactory.makeImage(imageData);
// now you have the real Image