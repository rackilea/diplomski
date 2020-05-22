MultipartEntityBuilder builder = MultipartEntityBuilder.create();        
builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

final File aFile = new File(fileName);
FileBody fileBody = new FileBody(file);

builder.addPart("file", fileBody);  
builder.addTextBody("requestId", requestId);
final HttpEntity httpEntity = builder.build();