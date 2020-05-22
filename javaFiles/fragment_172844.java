Map parameters = req.getParameterMap();

UploadedFile uploadedFile = (UploadedFile) parameters.get("file");

File serverFile = new File(uploadedFile.getServerFileName());
File clientFile = new File(serverFile.getParent() + java.io.File.separator + uploadedFile.getClientFileName());
serverFile.renameTo(clientFile);

MultipartEntityBuilder builder = MultipartEntityBuilder.create();

// fix <==========================
builder.setCharset(Charset.forName("UTF-8")).setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

builder.addPart("file", new FileBody(clientFile));
builder.addTextBody("field1", "Načrt", ContentType.create("text/plain", Charset.forName("UTF-8")));