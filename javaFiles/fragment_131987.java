//... get reader from response, can use response.success callback in http.request
ByteArrayDataSource ds = new ByteArrayDataSource(new ReaderInputStream(reader), "multipart/mixed");
MimeMultipart multipart = new MimeMultipart(ds);
BodyPart part = multipart.getBodyPart(1);
file = new File('/../../path/filename.pdf')
file << part.content