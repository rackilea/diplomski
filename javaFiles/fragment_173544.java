Document document = new Document();
PdfWriter.getInstance(document, new FileOutputStream("landscape.pdf"));
document.setPageSize(PageSize.A4.rotate());
document.setMargins(60, 30, 30, 30);
document.open();
document.add(new Paragraph("Test string for a landscape PDF."));
document.close();