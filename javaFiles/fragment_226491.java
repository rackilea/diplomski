PdfReader reader = new PdfReader("document.pdf");
PdfWriter writer = new PdfWriter("document-temp.pdf");
PdfDocument document = new PdfDocument(reader, writer);
...
document.close();
Path filePath = Path.of("document.pdf");
Path tempPath = Path.of("document-temp.pdf");
Files.move(tempPath, filePath, StandardCopyOption.REPLACE_EXISTING);