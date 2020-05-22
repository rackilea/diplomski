final Entry entry = this.createActivityEntry();
  final RequestOptions options = this.client.getDefaultRequestOptions();
  options.setHeader("Content-Type", "multipart/related;type=\"application/atom+xml\"");

  StringPart entryPart = new StringPart("entry", entry.toString());
  entryPart.setContentType("application/atom+xml");

  FilePart filePart = new FilePart("file", new File(resource.getFile()));           

  RequestEntity request = new MultipartRequestEntity(new Part[] { entryPart, filePart}, this.client.getHttpClientParams());
  ClientResponse response = client.post(this.url + this.activityId, request, options);