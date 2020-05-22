PDPage firstPage = getNewPage();
PDPageContentStream firstContentStream = new PDPageContentStream(document, firstPage);
firstContentStream.setFont(HEADING_FONT, HEADING_FONT_SIZE);
firstContentStream.setNonStrokingColor(Color.BLUE);
firstContentStream.beginText();
firstContentStream.newLineAtOffset(MARGIN, firstPage.getMediaBox().getHeight() - MARGIN);
firstContentStream.showText("1- Introduction");
// removed firstContentStream.endText();

firstContentStream.setFont(TEXT_FONT, TEXT_FONT_SIZE);
firstContentStream.setNonStrokingColor(Color.BLACK);
// removed firstContentStream.beginText();
firstContentStream.newLineAtOffset(0, -TEXT_FONT_SIZE); // reposition, tightly packed text lines
firstContentStream.showText("This document lists all the impacts that have been observed during the QA validation of the version v3.1 build");
firstContentStream.endText();
firstContentStream.close();
document.addPage(firstPage);