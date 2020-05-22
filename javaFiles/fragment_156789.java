MultipartEntityBuilder mb = null; 
org.apache.http.HttpEntity entity =null;
String value = String.format("https://%s.myotherserver.com%s", "sub1", request.getRequestURI());

mb = MultipartEntityBuilder.create();
mb.addTextBody("noproxy", "true");
mb.addTextBody("text", request.getParameter("text"));
mb.addTextBody("email", request.getParameter("email"));
mb.addBinaryBody("audio", new File(inputAudioFilename));

entity = mb.build();
URLConnection conn = new URL(urlStr[i]).openConnection();
conn.setDoOutput(true);
conn.addRequestProperty(entity.getContentType().getName(), entity.getContentType().getValue());
conn.addRequestProperty("Content-Length", String.valueOf(entity.getContentLength()));
OutputStream fout = conn.getOutputStream();
entity.writeTo(fout);//write multi part data...
fout.flush();
fout.close();
OutputStream output = response.getOutputStream();
output.flush();
                    ByteStreams.copy(conn.getInputStream(),response.getOutputStream());

conn.getInputStream().close();