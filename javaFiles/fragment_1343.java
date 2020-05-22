PDDocument document;
PDPage page;
PDPageContentStream contentStream;
document = new PDDocument();

page = new PDPage();
document.addPage(page);
contentStream = new PDPageContentStream(document, page);

contentStream.setFont(PDType1Font.COURIER, 10);

contentStream.beginText();
contentStream.moveTextPositionByAmount(100, 700);
contentStream.drawString("Hello World Hello World Hello World Hello World Hello World");
contentStream.endText();
contentStream.close();
document.save(....);
document.close();