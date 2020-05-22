MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
entity.addPart("someparameter1", new StringBody("Woody"));
entity.addPart("someparameter2", new StringBody("Woodpecker"));
File fileToSend = new File(filePath);
FileBody fileBody = new FileBody(fileToSend, "application/octet-stream");
entity.addPart("upload_file", fileBody);

httpPost.setEntity(entity);