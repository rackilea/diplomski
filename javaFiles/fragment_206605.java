// step 1
Document document = new Document();
// step 2
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PdfWriter.getInstance(document, baos);
// step 3
document.open();
// step 4
document.add(new Paragraph("Hello"));
// step 5
document.close();