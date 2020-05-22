// Request headers.
request.setHeader("Content-Type", "application/octet-stream");

// Request body.
File file = new File(imagePath);
FileEntity reqEntity = new FileEntity(file);
request.setEntity(reqEntity);