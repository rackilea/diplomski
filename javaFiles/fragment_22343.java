final ByteArrayOutputStream encoded = new ByteArrayOutputStream();
final OutputStream encoder = javax.mail.internet.MimeUtility.encode(encoded, "base64");
encoder.write(awsAccessKeyId);
encoder.flush();
encoder.close();
String accessKeyId = new String(encoded.toByteArray(), encoding).replaceAll("[\\r\\n]", "");