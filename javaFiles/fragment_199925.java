// step 1
Document document = new Document();
// step 2
PdfWriter.getInstance(document, new FileOutputStream(filename));
// step 3
document.open();
// step 4
[add content to the PDF]
// step 5
document.close();