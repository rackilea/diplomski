import java.util.Base64;

...

ByteArrayOutputStream baos = new ByteArrayOutputStream();
doc.save(baos);
String base64String = Base64.getEncoder().encodeToString(baos.toByteArray());
doc.close(); // don't forget to close your document