ByteArrayOutputStream baos = new ByteArrayOutputStream();
Document document = new Document();
PdfWriter.getInstance(document, baos);
document.open();
// add stuff
document.close();
byte[] pdf = baos.toByteArray();