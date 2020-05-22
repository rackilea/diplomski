// first create the document
Document document = new Document();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PdfWriter.getInstance(document, baos);
document.open();
addHTML(document, htmlStringToBeAdded);
document.close();
// Now you can use the document you've just created
PdfReader reader = new PdfReader(baos.toArray());
PdfReader existing = new PdfReader("c:\\pdf_issue\\bad1.pdf");
document = new Document();
PdfCopy copy = new PdfSmartCopy(document, new FileOutputStream("c:\\pdf_issue\\bad_itext3.pdf"));
document.open();
copy.addDocument(reader);
copy.addDocument(existing);
document.close();
reader.close();
existing.close();