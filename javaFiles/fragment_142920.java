PdfPCell cell = new PdfPCell();

Barcode128 barcode = new Barcode128();
barcode.setCode(code);
Image barcodeImage = barcode.createImageWithBarcode(writer.getDirectContent(), BaseColor.BLACK, BaseColor.GRAY);
cell.addElement(barcodeImage);

Paragraph paragraph = new Paragraph("Hello World"); 
cell.addElement(paragraph);