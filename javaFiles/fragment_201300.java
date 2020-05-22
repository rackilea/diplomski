PDPage page = new PDPage(PDRectangle.A4);
page.setRotation(90);
doc.addPage(page);
PDRectangle pageSize = page.getMediaBox();
float pageWidth = pageSize.getWidth();
PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false);
// add the rotation using the current transformation matrix
// including a translation of pageWidth to use the lower left corner as 0,0 reference
contentStream.transform(new Matrix(0, 1, -1, 0, pageWidth, 0));
(...)