PDDocument document = PDDocument.load("0006-sun1-4.pdf");
List<PDPage> allPages = document.getDocumentCatalog().getAllPages();
PDPage firstPage = allPages.get(0);
PDRectangle pageSize = firstPage.findMediaBox();

PDStream contents = firstPage.getContents();  
PDFStreamParser parser = new PDFStreamParser(contents.getStream()); 
parser.parse();
List<Object> tokens = parser.getTokens();
tokens.add(0, PDFOperator.getOperator("q"));
tokens.add(PDFOperator.getOperator("Q"));
PDStream updatedStream = new PDStream(document);  
OutputStream out = updatedStream.createOutputStream();  
ContentStreamWriter tokenWriter = new ContentStreamWriter(out);  
tokenWriter.writeTokens(tokens);  
firstPage.setContents(updatedStream);

PDPageContentStream contentStream = new PDPageContentStream(document, firstPage, true, true);
contentStream.setStrokingColor(Color.red);
contentStream.beginText();
contentStream.moveTextPositionByAmount(300, pageSize.getUpperRightY() - 420 - 10);
contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
contentStream.drawString("MIDDLE");
contentStream.endText();
contentStream.close();

document.save("0006-sun1-4-restoredAdd.pdf");
document.close();