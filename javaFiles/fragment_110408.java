public void createPdf(String dest) throws IOException, DocumentException {
    Image img = Image.getInstance(IMAGES[0]);
    Document document = new Document(img);
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    for (String image : IMAGES) {
        img = Image.getInstance(image);
        document.setPageSize(img);
        document.newPage();
        img.setAbsolutePosition(0, 0);
        document.add(img);
    }
    document.close();
}