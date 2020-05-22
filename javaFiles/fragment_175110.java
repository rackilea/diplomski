Request request = new Request.Builder()
        .url(url)
        .addHeader("range", String.format("bytes=%s", TextUtils.join(", ", ranges)))
        .build();
Response response = client.newCall(request).execute();
ByteArrayDataSource dataSource = new ByteArrayDataSource(response.body().byteStream(), response.body().contentType().toString());
MimeMultipart multipart = new MimeMultipart(dataSource);
int count = multipart.getCount();
for (int i = 0; i < count; i++) {
    BodyPart bodyPart = multipart.getBodyPart(i);
    if (bodyPart.isMimeType("application/octet-stream")) {
        processBinaryStream(bodyPart.getInputStream());
    } else {
        // Or process different types of data
        throw new Exception(String.format("Content type: %s cannot be parsed", bodyPart.getContentType()));
    }
}