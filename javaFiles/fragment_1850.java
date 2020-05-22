CloseableHttpClient httpClient = HttpClients.createDefault();
HttpPost uploadFile = new HttpPost("...");
MultipartEntityBuilder builder = MultipartEntityBuilder.create();
builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

// This attaches the file to the POST:
File f = new File("[/path/to/upload]");
builder.addBinaryBody(
    "file",
    new FileInputStream(f),
    ContentType.APPLICATION_OCTET_STREAM,
    f.getName()
);

HttpEntity multipart = builder.build();
uploadFile.setEntity(multipart);
CloseableHttpResponse response = httpClient.execute(uploadFile);
HttpEntity responseEntity = response.getEntity();