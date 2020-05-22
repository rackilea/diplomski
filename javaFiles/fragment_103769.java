Attachments attachments = new Attachments();
String filePath = "/Users/david/Desktop/screenshot5.png";
try {
    byte[] encoded = Base64.encodeBase64(Files.readAllBytes(Paths.get(filePath)));
    String encodedString = new String(encoded);
    attachments.setContent(encodedString);
} catch (IOException e) {
}