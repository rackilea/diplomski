HttpRequestFactory httpRequestFactory = getHttpRequestFactory(username);

Map<String, String> parameters = Maps.newHashMap();
parameters.put("printerid", printRequest.getPrinterId());
parameters.put("title", printRequest.getTitle());
parameters.put("contentType", printRequest.getContentType());

// Map print options into CJT structure
Map<String, Object> options = Maps.newHashMap();
options.put("version", "1.0");
options.put("print", printRequest.getOptions());
parameters.put("ticket", new Gson().toJson(options));

// Add parameters
MultipartContent content = new MultipartContent().setMediaType(
        new HttpMediaType("multipart/form-data")
                .setParameter("boundary", "__END_OF_PART__"));
for (String name : parameters.keySet()) {
    MultipartContent.Part part = new MultipartContent.Part(
            new ByteArrayContent(null, parameters.get(name).getBytes()));
    part.setHeaders(new HttpHeaders().set(
            "Content-Disposition", String.format("form-data; name=\"%s\"", name)));
    content.addPart(part);
}

// Add file
FileContent fileContent = new FileContent(
        printRequest.getContentType(), printRequest.getFile());
MultipartContent.Part part = new MultipartContent.Part(fileContent);
part.setHeaders(new HttpHeaders().set(
        "Content-Disposition", 
        String.format("form-data; name=\"content\"; filename=\"%s\"", printRequest.getFile().getName())));
content.addPart(part);

try {
    HttpResponse response = httpRequestFactory.buildPostRequest(
            SubmitUrl, content).execute();
    System.out.println(IOUtils.toString(response.getContent()));
} catch (IOException e) {
    ...
}