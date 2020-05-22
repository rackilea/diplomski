InputStreamBody metadata = new InputStreamBody(xmlMetadata, "application/atom+xml; charset=UTF-8");
FileBody content = new FileBody(new File("video.mp4"), "application/octet-stream");
MultipartEntity reqEntity = new MultipartEntity();
reqEntity.addPart("metadata", metadata);
reqEntity.addPart("content", content);
post.setEntity(reqEntity);
client.execute(post);