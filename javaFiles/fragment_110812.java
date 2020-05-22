Document document = new Document(new Rectangle(340, 842));
PdfWriter writer = PdfWriter.getInstance(document, 
    new FileOutputStream("barcodes.pdf"));
document.open();
PdfContentByte cb = writer.getDirectContent();

document.add(new Paragraph("Barcode 128 demo"));

Barcode128 code128 = new Barcode128();
code128.setCode("100");
code128.setCodeSet(Barcode128CodeSet.B);
document.add(code128.createImageWithBarcode(cb, null, null));

code128 = new Barcode128();
code128.setCode("1001");
code128.setCodeSet(Barcode128CodeSet.B);
document.add(code128.createImageWithBarcode(cb, null, null));
document.close();