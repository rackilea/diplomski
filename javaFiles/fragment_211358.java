ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream ps = new PrintStream(baos);
Document document = new Document();
PdfWriter.getInstance(document, ps);
document.open();
// add content
document.close();