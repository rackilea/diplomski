MimeMessageParser parser = new MimeMessageParser(yourMimeMessage);
parser.parse();

String htmlContent = parser.getHtmlContent();
// or
String plainContent = parser.getPlainContent();