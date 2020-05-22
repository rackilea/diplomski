// second part (the image)
messageBodyPart = new MimeBodyPart();
DataSource fds = new FileDataSource
  ("C:\\images\\cec_header_457.png");
DataSource fds1 = new FileDataSource
("C:\\images\\cec_header_420.png");
messageBodyPart.setDataHandler(new DataHandler(fds));
messageBodyPart.setDataHandler(new DataHandler(fds1));
messageBodyPart.addHeader("Content-ID","<image>");
messageBodyPart.addHeader("Content-ID","<senny>");
// add it
multipart.addBodyPart(messageBodyPart);