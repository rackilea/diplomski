File body = new File();
body.setTitle(title);
body.setDescription(description);
body.setMimeType(mimeType);

java.io.File fileContent = new java.io.File(filename);
FileContent mediaContent = new FileContent(mimeType, fileContent);

Drive.Files.Insert insert = drive.files().insert(body, mediaContent);
insert.getMediaHttpUploader().setChunkSize(1024 * 1024);
File file = insert.execute();