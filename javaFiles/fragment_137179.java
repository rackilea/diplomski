//
// This HTML mail have to 2 part, the BODY and the embedded image
//
MimeMultipart multipart = new MimeMultipart("related");

// first part  (the html)
BodyPart messageBodyPart = new MimeBodyPart();
String htmlText = "<H1>Hello</H1><img src=\"cid:image@foo.com\">";
messageBodyPart.setContent(htmlText, "text/html");

// add it
multipart.addBodyPart(messageBodyPart);

// second part (the image)
messageBodyPart = new MimeBodyPart();
DataSource fds = new FileDataSource
  ("C:\\images\\foo.gif");
messageBodyPart.setDataHandler(new DataHandler(fds));
messageBodyPart.setHeader("Content-ID","<image@foo.com>");

// add it
multipart.addBodyPart(messageBodyPart);

// put everything together
message.setContent(multipart);