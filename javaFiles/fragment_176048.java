File file = new File(pdfFilePath);
PDDocument document = PDDocument.load(file);
ObjectExtractor oe = new ObjectExtractor(document);
Page page = oe.extract(1); // 1st page

for (TextElement textElement: page.getText()) {
  System.out.print(textElement.getText());
}