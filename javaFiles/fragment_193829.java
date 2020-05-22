PDDocument document = PDDocument.load("0006-sun1-4.pdf");
List<PDPage> allPages = document.getDocumentCatalog().getAllPages();
PDPage firstPage = allPages.get(0);
PDRectangle pageSize = firstPage.findMediaBox();

PDPageContentStream contentStream = new PDPageContentStream(document, firstPage, true, true);
contentStream.setStrokingColor(Color.red);
contentStream.beginText();
contentStream.moveTextPositionByAmount(300/.24f, (pageSize.getUpperRightY() - 420 - 10)/.24f);
contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10/.24f);
contentStream.drawString("MIDDLE");
contentStream.endText();
contentStream.close();

document.save("0006-sun1-4-scaledAdd.pdf");
document.close();