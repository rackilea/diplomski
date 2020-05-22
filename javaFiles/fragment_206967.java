Document document = new Document(PageSize.A4, 20, 20, 20, 20);
PdfWriter.getInstance(document, new FileOutputStream("C:/test.pdf"));
document.open();
Image image = Image.getInstance(getClass().getResource("/logo.png"));
document.add(image);
document.close();