ByteArrayOutputStream baos = new ByteArrayOutputStream();
Document document = new Document();
PdfWriter.getInstance(document, baos);
document.open();
// add content
document.close();
byte[] pdf = baos.toByteArray();